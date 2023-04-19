> Pokemon Card generator
---
Java Spring Boot application that handles requests to get json from Pokemon TCG API
(pokemontcg.io) and saves it to local MySQL database.

- Getting Pokemon Cards from Pokemon TCG API
- Parsing JSON input into POJO's
- Saving POJO's into local MySQL DB
>Rest API ("/api/v1/pokemoncards") :
- "/all" - get all Pokemon Cards in DB
- "/find/{id}" - find Pokemon Card by id
- "/add" - add Pokemon Card to DB
- "/update" - update Pokemon Card in DB
- "/delete/{id}" - delete Pokemon Card from DB

---

Backend only

Application is on early stage
