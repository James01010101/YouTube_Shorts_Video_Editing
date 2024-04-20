




# clean the java backend compiled code before recompiling
clean_backend:
	cd backend && mvn clean

# compile the java backend code
compile_backend: clean_backend
# cd to the right directory
# -e to show errors
	cd backend && mvn compile

# compile and run the backend java code
compile_run_backend: clear compile_backend
	cd backend && mvn exec:java -Dexec.mainClass="Main"

# just run the backend java code dont clean and recompile if im not changing anything
run_backend: clear
	cd backend && mvn exec:java -Dexec.mainClass="Main"




run_frontend: clear
	cd frontend && npm start


# run the tests for the frontend
test_frontend: clear
	cd frontend && npm test


# so this can be used as a depedance so i can do it first before other makes
clear:
	clear


# clean all of the files out for builds so i can start over
clean: clear clean_backend