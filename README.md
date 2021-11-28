# docker-example
 Example of dockerization and integration of an application with docker-compose for Cloud Computing at the University of Milan-Bicocca

# Requirements
Docker
# Build the image
`
docker build . -t app
`
# Compose and run the application

`docker-compose up -d`

# Usage

| Operation | URL                        | Parameters                   | Returned value                                                                                        |
|-----------|----------------------------|------------------------------|-------------------------------------------------------------------------------------------------------|
| GET       | localhost:8080             | None                         | Display all messages                                                                                  |
| POST      | localhost:8080/add         | name: string message: string | A new message is added                                                                                |
| PUT       | localhost:8080/{id}        | None                         | Modifies the message with id == {id}; if it does not exist, a new message is created, similar to /add |
| DELETE    | localhost:8080/delete/{id} | None                         | Delete message with id == {id}                                                                        |