# GeoJSON AND GIS ON A SPRING PROJECT

![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)

This project is a Zé Delivery Code Challenge resolution.

## About this project

On this project, the challenge was to work with GeoJSON and GIS. 

### The main goals for this project are:

* Build and endpoint to register new Partner
* Each partner has on or more coverage areas (areas where they can deliver) represented by Polygons made of longitude and latitude points.
* Each partner has also an address, which is represented by a point (longitude, latitude)
* We should be able to receive both coverage areas and address on a GeoJSON.
* We should be able to persist coverage areas and address for each client (along with other info like id and a unique document)
* We need an endpoint where users can find for a partner by id
* We need and endpoint where user can inform his location (longitude, latitude) and we return the nearest partner that has a coverage area that includes the user location 

## How to run this project locally

1. Clone this project
2. Open the folder you just created on your favorite IDE
3. Install dependencies with Maven
4. Access local folder with `cd local`
5. Run `docker compose up`, which will create a PostGIS docker container.
6. Local PG variables are already configured on application.properties. You may change it if necessary
7. Start the project
8. Project will run on `http://localhost:8080`

## Documentation

This project has 3 endpoints:

### Expected DTO Inputs:

#### PartnerInput

```
{
	"tradingName": "Bussines Name",
	"document": "04.433.714/0001-44",
	"coverageArea": {
		 "type": "MultiPolygon",
		 "coordinates": [
				[
                 [
                        [
                             -49.36299,
                             -25.4515
                        ],
                        [
                             -49.35334,
                             -25.45065
                        ],
                        [
                             -49.33675,
                             -25.4429
                        ],
                        [
                             -49.32291,
                             -25.4398
                        ],
                        [
                             -49.3188,
                             -25.44089
                        ],
                        [
                             -49.31064,
                             -25.43903
                        ],
                        [
                             -49.29828,
                             -25.43391
                        ],
                        [
                             -49.29751,
                             -25.43377
                        ],
                        [
                             -49.29588,
                             -25.43322
                        ],
                        [
                             -49.29215,
                             -25.43189
                        ],
                        [
                             -49.28855,
                             -25.43043
                        ],
                        [
                             -49.28662,
                             -25.42958
                        ],
                        [
                             -49.28424,
                             -25.42865
                        ],
                        [
                             -49.25803,
                             -25.42853
                        ],
                        [
                             -49.25533,
                             -25.42279
                        ],
                        [
                             -49.25585,
                             -25.4169
                        ],
                        [
                             -49.25524,
                             -25.40981
                        ],
                        [
                             -49.25761,
                             -25.40403
                        ],
                        [
                             -49.25524,
                             -25.39787
                        ],
                        [
                             -49.26005,
                             -25.39178
                        ],
                        [
                             -49.26078,
                             -25.3819
                        ],
                        [
                             -49.26267,
                             -25.37348
                        ],
                        [
                             -49.25952,
                             -25.37003
                        ],
                        [
                             -49.25971,
                             -25.36597
                        ],
                        [
                             -49.26301,
                             -25.35774
                        ],
                        [
                             -49.26468,
                             -25.34742
                        ],
                        [
                             -49.30623,
                             -25.35119
                        ],
                        [
                             -49.36262,
                             -25.36639
                        ],
                        [
                             -49.37043,
                             -25.3798
                        ],
                        [
                             -49.36743,
                             -25.40593
                        ],
                        [
                             -49.36837,
                             -25.42578
                        ],
                        [
                             -49.36299,
                             -25.4515
                        ]
					 ]
				]
		 ]
	},
	"address": {
		 "type": "Point",
		 "coordinates": [
				-49.33425,
				-25.380995
		 ]
	}
 },
```

#### NearestPartnerSearch

```
{
    "longitude": -49.33425,
    "latitude": -25.380995	
}
```

## Technologies

* Java 21 and Spring Boot 3.3.2
* Spring WEB and Spring Data JPA
* Bean validation with Hibernate Validator
* Lombok
* Postgres with PostGIS
* Flyway


## Found a bug or want to contribute to this project?

If you've found a bug, make sure you open an Issue on this project repository. Also, all users are welcome to submit pull requests, but remember to mention on the PR which Issue are you fixing on it.


