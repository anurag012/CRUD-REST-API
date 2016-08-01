# CRUD-REST-API

This is a REST API using Spring MVC. Follows MVC pattern. Used Spring framework, JPA, Hibernate, ORM, Javax servlet, mysql-connector.
Used Maven to manage all these dependencies. All dependencies are managed in Pom.xml file.

## AppConfig.java
This file enables the web mvc for the application.

    @Configuration
    @ComponentScan
    @EnableWebMvc
    public class AppConfig {
    }
Component scan enables to search for components within the application.
## JPAConfig.java
This class creates beans for database connection, entity manager factory. Also, it initializes hibernate properties.
for database, set driver, url, username, password.

## CORSFilter.java
This class enables the CORS(cross origin resource sharing) so that this api can be used with any platform and any frontend appliation.

## AppInitializer.java
This class combines all the configuration classes, allows you to specify text that you want to include in URL (e.g. "/api/").

## controller/UserController.java
This is the most important part of application. controller takes the URL and passes it to appropriate method. 
For example, for a **GET** request:
    
    	private UserService service;
	
	@RequestMapping(method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<User> findAll(){
		return service.findAll();
	}
Controller passes this request to service which in turn passes it to repository.Repository does the database queries.

## service/UserServiceImpl.java
Put all the business logic here. For example, to find a user with specific id, we check if the user exists by making a database request,
If exists then we pass id to appropriate method in repository.

    private UserRepository repository;
    @Override
    public User findOne(String id) {
    User existing = repository.findOne(id);
    if(existing==null){
    throw new UserNotFound("User with id = "+id+" not found");
    }
    return existing;
    }

## repository/UserRepositoryImpl.java
Here, we do not put any conditions. We directly perform database operations because we are checking for conditions on service layer.

    @PersistenceContext
    private EntityManager em;
    @Override
    public List<User> findAll() {
    TypedQuery<User> query = em.createQuery("from User", User.class);
    return query.getResultList();
    }
	
That's the main components of application.
