FROM jboss/wildfly:13.0.0.Final

ADD web/target/myWords-web-1.0-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/

ENV HOME="/tmp"
ADD config.properties /tmp/
ADD input_words.csv /tmp/

RUN /opt/jboss/wildfly/bin/add-user.sh root pass123 --silent

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]


