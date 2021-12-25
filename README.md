# Libraries
Repo to explore some libraries ( Testing libraries for now )

1. With Stubs we have to write class implementation as in BusinessServiceStub and use it.
   Number of lines keeps increasing when multiple scenarios have to be tested and also any change to interface would 
   break stub and maintenance is also difficult. So mocks are preferred.
2. Spring has 2 setups for Mockmvc. 
   1. Standalone setup
   2. WebApplicationContext setup
3. Lifecyles in maven are default, clean and site of which maven default lifecycle is important.
4. Default lifecycle has following main phases
   1. validate
   2. compile
   3. test
   4. package
   5. verify
   6. install
   7. deploy
   maven-surefire-plugin is used at test phase to run unit tests(core plugin. Maven picks default version if not specified)
   maven-failsafe-plugin is used at verify phase to run integration tests.(Not a core plugin. so need to specify manually)
5. -Dmaven.test.skip=true skips compiling and running test cases whereas -DskipTests only skips testcase execution
6. spring-boot-test depedency adds Mockito, Junit, JSONPath and different assertion libraries like hamcrest, AssertJ , JsonAssert.
