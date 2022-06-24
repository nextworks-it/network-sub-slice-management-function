# Download base image ubuntu 18
FROM ubuntu:20.04 AS basic-nssmf-builder
ARG GITLAB_USER
ARG GITLAB_TOKEN
ARG VS_COMMON_BRANCH=master

#non interactive tzdata config
ENV DEBIAN_FRONTEND=noninteractive
# Update Ubuntu software repository and install prerequisites
RUN apt-get update && apt-get install -y \
    git \
    systemd \
    wget \
    openjdk-8-jdk \
    sudo

RUN useradd -ms /bin/bash ubuntu
# Install Maven 3.3.9
RUN wget http://apache-mirror.rbc.ru/pub/apache/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz \
    && tar -xvzpf apache-maven-3.3.9-bin.tar.gz \
    && mkdir -p /opt/maven/3.3.9 \
    && mv apache-maven-3.3.9/* /opt/maven/3.3.9/ \
    && rm -rf apache-maven-3.3.9 \
    && rm apache-maven-3.3.9-bin.tar.gz \
    && ln -s /opt/maven/3.3.9/ /opt/maven/current
ENV MAVEN_HOME=/opt/maven/current
ENV PATH=$PATH:$MAVEN_HOME/bin
RUN mkdir /root/.ssh/
# Get all the component
RUN echo "Host gitlab.nextworks.it\n\tStrictHostKeyChecking no\n" >> /root/.ssh/config
USER root

RUN git clone --branch nst_update_28.541_16.06 https://$GITLAB_USER:$GITLAB_TOKEN@gitlab.nextworks.it/kd_nextworks/nfv-ifa-libs.git /home/ubuntu/nfv-ifa-libs
RUN cd /home/ubuntu/nfv-ifa-libs/ && mvn clean install -DskipTests

RUN git clone --branch master https://$GITLAB_USER:$GITLAB_TOKEN@gitlab.nextworks.it/kd_nextworks/nfv-sol-libs.git /home/ubuntu/nfv-sol-libs
RUN cd /home/ubuntu/nfv-sol-libs/ && ./install_nfv_sol_libs.sh

#ADD "https://gitlab.nextworks.it/api/v4/projects/147/repository/branches/$VS_COMMON_BRANCH?private_token=$GITLAB_TOKEN" /tmp/vs-common-cache
RUN git clone --branch $VS_COMMON_BRANCH https://$GITLAB_USER:$GITLAB_TOKEN@gitlab.nextworks.it/kd_nextworks/vertical-slicer-common-libs.git /home/ubuntu/vs-common
RUN cd /home/ubuntu/vs-common/vs-common-libs && mvn clean install -DskipTests

RUN git clone --branch anchor-dev https://$GITLAB_USER:$GITLAB_TOKEN@gitlab.nextworks.it/kd_nextworks/nssmf-record.git /home/ubuntu/nssmf-record && \
    cd /home/ubuntu/nssmf-record && mvn clean install -DskipTests