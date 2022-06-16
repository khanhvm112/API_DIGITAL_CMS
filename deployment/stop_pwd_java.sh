currentDir=`pwd`
pgrep java | while read -r line ; do
    processDir=`pwdx $line | awk {'print $2'}`
    if [ "$currentDir" = "$processDir" ]
    then
	kill -9 $line
    fi
done
