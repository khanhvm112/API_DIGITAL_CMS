currentDir=`pwd`
pgrep java | while read -r line ; do
    processDir=`pwdx $line | awk {'print $2'}`
    if [ "$currentDir" = "$processDir" ]
    then
	jstack $line > jstack.log
    fi
done
