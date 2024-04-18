




# clean the java backend compiled code before recompiling
clean_backend:
	cd backend && mvn clean

# compile the java backend code
compile_backend: clean_backend
# cd to the right directory
# -e to show errors
	cd backend && mvn compile

# run the backend java code
run_backend: clear compile_backend
	cd backend && mvn exec:java -Dexec.mainClass="Main"


# so this can be used as a depedance so i can do it first before other makes
clear:
	clear


# clean all of the files out for builds so i can start over
clean: clear clean_backend