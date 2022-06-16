mkdir log
cd log
mkdir general
cd ..
status=1
while [ $status = 1 ]
do
	java -Xmx512m -Dlog4j.configuration=file:resource/log4j.properties -classpath "lib/*" com.imedia.ApiDigitalCmsApplication --spring.config.location=resource/application.properties
	status=$?
done
