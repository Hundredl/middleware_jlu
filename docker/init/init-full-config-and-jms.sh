# Switch to full configuration
echo "=> Switch to full configuration"
cp ${JBOSS_HOME}/standalone/configuration/standalone-full.xml ${JBOSS_HOME}/standalone/configuration/standalone.xml

echo "=> add role"
$JBOSS_HOME/bin/add-user.sh --silent=true -a testJNDI 123
echo -e "\ntestJNDI=testrole" >> ${JBOSS_HOME}/standalone/configuration/application-roles.properties
echo -e "\ntestJNDI=testrole" >> ${JBOSS_HOME}/domain/configuration/application-roles.properties

# Add JMS role
echo "=> Add JMS role"
sed -i 's/<permission type="send" roles="guest"\/>/<permission type="send" roles="guest testrole"\/>/' \
    ${JBOSS_HOME}/standalone/configuration/standalone.xml
sed -i 's/<permission type="consume" roles="guest"\/>/<permission type="consume" roles="guest testrole"\/>/' \
    ${JBOSS_HOME}/standalone/configuration/standalone.xml
