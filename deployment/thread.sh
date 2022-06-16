#! /bin/bash
#
# chkconfig: 35 95 5
# description: Startup/Shutdown script
# WORK_DIR=/app/ftl/service
# cd $WORK_DIR
pid_file=thread.pid
APP_NAME='API_DIGITAL_CMS'

RUNNING=0

if [ -f $pid_file ]; then
	pid=`cat $pid_file`
	if [ "x$pid" != "x" ] && kill -0 $pid 2>/dev/null; then
		RUNNING=1
	fi
fi

start()
{
	if [ $RUNNING -eq 1 ]; then
		echo $APP_NAME" already started"
	else
		./run.sh > /dev/null 2>&1 & 
		#./run.sh & 
		echo $! > $pid_file
		echo $APP_NAME" started"
	fi
}

stop()
{
	if [ $RUNNING -eq 1 ]; then
		./log_stack.sh
		pkill -TERM -P $pid
		kill -9 $pid
		RUNNING=0
		./stop_pwd_java.sh
		echo $APP_NAME" stopped"
	else
		echo $APP_NAME" not running"
	fi
}

restart()
{
	stop
	start
}

case "$1" in

	'start')
		start
		;;

	'stop')
		stop
		;;

	'restart')
		restart
		;;

	*)
		echo "Usage: $0 {  start | stop | restart  }"
		exit 1
		;;
esac
exit 0