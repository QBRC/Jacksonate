Jacksonate Shared Library
===============

About
---------------
This is a shared library for custom JSON serialization and deserialization for RESTEasy services using Jackson.  See our Guiberest sample application for an example of using the Jacksonate Library (https://github.com/QBRC/Guiberest). 

dataprotocols Implementation
---------------
The Jacksonate library includes an implementation of the JSON Table Schema (https://github.com/dataprotocols/dataprotocols/blob/master/source/json-table-schema.rst) and Data Packages (https://github.com/dataprotocols/dataprotocols/blob/master/source/data-packages.rst)
defined by the dataprotocols project at https://github.com/dataprotocols/.

JSON Table Schema
-----------------
Jacksonate provides serializers and deserializers for writing and reading JSON data in the JSON Table Schema format.  It includes
a ``TableJSONContainer`` class that can be used as a wrapper when you desire JSON output that meets the JSON Table Schema specifications:

The Guiberest project (https://github.com/QBRC/Guiberest) includes a complete example of a RESTful Web Service using RESTEasy and Jacksonate to output Hibernate persistence objects in the JSON Table Schema format.

Example:
-----------
RESTful Web Service Method that outputs a list of objects in the JSON Table Schema format:
```java
public TableJSONContainer<User> getUsers() {
	try {
		List<Constraint> constraints = new ArrayList<Constraint>();
		return new TableJSONContainer<User>(userDao.findAll(constraints));
	} catch(NoResultException e) {
		throw new BadRequestException("Invalid query provided -- no such user/s.");
	}
}
```

Output:
----------
```javascript
{
  "java_type":"edu.swmed.qbrc.guiberest.shared.domain.guiberest.User",
  "fields":[
    {
      "id":"id",
      "label":"id",
      "type":"string"
    },
    {
      "id":"password",
      "label":"password",
      "type":"string"
    },
    {
      "id":"secret",
      "label":"secret",
      "type":"string"
    }
  ],
  "data":[
    ["thomas","password","123456789"],
    ["roger","password","987654321"]
  ]
}
```

Data Package
-----------------
The Jacksonate library also includes a ``DataPackage`` class, along with both a custom serializer and deserializer, to enable
easy output of a "datapackage.json" JSON object that implements the dataprotocols "Data Package" specification.  

Simply annotate the classes that should be inclucded in your datapackage.json as follows:
```java
@DataPackageClass(url="user")
```

Then, include a RESTful method that returns a ``Datapackage`` object:
```java
public DataPackage getDataPackage() {
	return new DataPackage();
}
```

Foreign Key Support
----------------
Both the DataPackage serializer and the TableJSONContainer serializer support foreign keys as mentioned in the dataprotocols specifictions.

Annotate your domain object properties that reference foreign keys as follows:
```java
@DataPackageForeignKey(foreignClass = Dataset.class)
```


Getting Started
---------------
Follow the steps below to download, compile and install this library in your local Maven repository.

Download the Jacksonate library:
```bash
git clone https://github.com/QBRC/Jacksonate.git
```

Compile the Jacksonate library
```bash
cd Jacksonate/
mvn clean install  
```
