# Eventshuffle

Dockerized, Spring Boot and Postgres -powered backend for an app for 
scheduling events with your friends!

# Run the backend:
- Make sure you are connected to the internet
- Prerequisites: Docker, e.g. version 20.10.12 and docker compose v2.12.0
- Run backend with `docker compose up` in the repo root directory.
- The app is now served in `localhost:8080`.

## Should you want to make edits and rebuild the software, then:
- Make sure you are connected to the internet
- Prerequisites: Java 19 with compatibatle Maven 
- Build with Maven in repo root dir: `./mvnw clean package -DskipTests`
- Then run the backend, again with docker compose up

# What's the app like?:

Architecture was inspired by microservices and layered architecture. It 
consist of a containerized service, that defines an RESTful API, accepts 
JSON, performs some basic data validation and persists the data in a database.

The layered structure of the service itself is best explained as an image that 
illustrates data flow through the service. See figure 1.

Implementation considers logging and handling Java-required boilerplate, 
illustrates some exception handling and data formatting.

## Implemented API
Implementation as per defined in [Eventshuffle backend API](https://gist.github.com/VilluNikolaiV/44eae2829f7ece9c0d0657d502ed8c63).
Implementation is partial and consists of endpoints:

- List all events via GET to ``/api/v1/event/list``
- Create an event via POST to ``/api/v1/event``
- Show an event* via GET to ``/api/v1/event/{id}``

* with the restriction that the attribute `votes` does not yet receive or display data.

That is, voting-related features are not yet implemented, including the API endpoints:

- Voting an event via `POST` to `/api/v1/event/{id}/vote`
- Showing the results of an event via `GET` to `/api/v1/event/{id}/results`

## Known restrictions and deficits:
- Main deficit is no tests whatsoever :( Can't really know if it works, or be 
assured of no-regression withouth tests. For example, I'm rather certain the API is 
somewhat fragile, since I tested few negative cases manually. The pitfalls would 
get exposed through testing.
- Exposing DB IDs to client. Could be mapped to another ID for security.
- DB-modeling.
- Also forgot to check that application/json -headers are required, in and out.
- No user account / session / permission management. If implemented, would be 
it's own (micro)service (or two), e.g. "user-registering-service".

# Other notes:

- Against the principle of using domain-specific terms in the software,
  familiar from domain-driven design (DDD), this app uses the term "happening" 
  instead of "event" to keep events from getting mixed up with handling 
  of (application) events.
