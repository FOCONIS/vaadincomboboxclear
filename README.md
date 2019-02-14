vaadincomboboxclear
===================

Demonstrate the problem in Vaadin Testbench issue #1122 - Testbench API clear() e.g. broken on ComboBox

https://github.com/vaadin/testbench/issues/1122


Workflow
========

To run the integration-test demonstrating the problem run "mvn verify"

To compile the entire project, run "mvn install".

To run the application, run "mvn jetty:run" and open http://localhost:8080/ .

To produce a deployable production mode WAR:
- change productionMode to true in the servlet class configuration (nested in the UI class)
- run "mvn clean package"
- test the war file with "mvn jetty:run-war"
