FROM basic-nssmf-builder as tn-nssmf-builder

ARG GITLAB_USER
ARG GITLAB_TOKEN
ARG NSSMF_BRANCH

RUN git clone --branch $NSSMF_BRANCH https://$GITLAB_USER:$GITLAB_TOKEN@gitlab.nextworks.it/kd_nextworks/network-sub-slice-management-function.git /home/ubuntu/network-sub-slice-management-function/ && \
    cd /home/ubuntu/network-sub-slice-management-function/nssmf-service && mvn clean install -DskipTests

RUN git clone --branch development https://$GITLAB_USER:$GITLAB_TOKEN@gitlab.nextworks.it/kd_nextworks/external-clients.git /home/ubuntu/external-clients && \
    cd /home/ubuntu/external-clients/cttc-tapi-client && mvn clean install -DskipTests

RUN cd /home/ubuntu/network-sub-slice-management-function/tn-nssmf && mvn clean install -DskipTests

RUN cd /home/ubuntu/network-sub-slice-management-function/nssmf-app && mvn clean install -DskipTests -Dhandler.groupId=it.nextworks.nfvmano -Dhandler.artifactId=tn-nssmf-handler -Dhandler.version=0.0.1-SNAPSHOT

FROM ubuntu:20.04 

#non interactive tzdata config
ENV DEBIAN_FRONTEND=noninteractive
# Update Ubuntu software repository and install prerequisites
RUN apt-get update && apt-get install -y \
    wget \
    openjdk-8-jdk \
    sudo
COPY --from=tn-nssmf-builder /home/ubuntu/network-sub-slice-management-function/nssmf-app/target/nssmf-app-0.0.1.jar /home/ubuntu/