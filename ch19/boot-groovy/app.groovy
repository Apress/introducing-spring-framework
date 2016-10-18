@Grab("org.hsqldb:hsqldb:2.2.9")
@Grab("org.codehaus.groovy:groovy-sql:2.0.1")

@Configuration
class MyDocuments  {
   //Extra configuration 	
}

beans {
	importBeans("jdbc.xml")

}
