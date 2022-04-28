run: FDBackendMadisonMap.class FrontendMadisonMap.class FDEdge.class FDIEdge.class FDIShortestPath.class FDIVertex.class FDShortestPath.class FDVertex.class
	java FrontendMadisonMap	

runTests: runFrontendDeveloperTests

runFrontendDeveloperTests: FrontendDeveloperTests.class
	java -jar junit5.jar -cp . --scan-classpath -n FrontendDeveloperTests

FrontendDeveloperTests.class: FDBackendMadisonMap.class FrontendMadisonMap.class FDEdge.class FDIEdge.class FDIShortestPath.class FDIVertex.class FDShortestPath.class FDVertex.class
	javac -cp .:junit5.jar FrontendDeveloperTests.java

FDBackendMadisonMap.class: FDBackendMadisonMap.java
	javac FDBackendMadisonMap.java

FrontendMadisonMap.class: FrontendMadisonMap.java
	javac FrontendMadisonMap.java

FDEdge.class: FDEdge.java
	javac FDEdge.java

FDIEdge.class: FDIEdge.java
	javac FDIEdge.java

FDIShortestPath.class: FDIShortestPath.java
	javac FDIShortestPath.java

FDIVertex.class: FDIVertex.java
	javac FDIVertex.java

FDShortestPath.class: FDShortestPath.java
	javac FDShortestPath.java

FDVertex.class: FDVertex.java
	javac FDVertex.java

clean:
	rm *.class
