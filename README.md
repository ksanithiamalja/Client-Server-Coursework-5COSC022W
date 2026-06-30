# MLOps Pipeline Management API

- **Student Name:** Sanithi Amalja
- **IIT ID:** 20231765
- **UOW ID:** W2153569
- **Module:** 5COSC022W - Client-Server Architectures
- **Coursework:** MLOps Pipeline Management API (Reassessment)



## Video Demonstration
https://drive.google.com/file/d/1p9xLIgcYZTlvN5vUw4xV0zTvl_vJ7idY/view?usp=sharing

---

A RESTful API built with **JAX-RS (Jersey)** and **Grizzly HTTP Server** for managing Machine Learning Workspaces, Models, and Evaluation Metrics.

## Technology Stack

- **Java 11**
- **JAX-RS** (Jersey 3.1.3)
- **Grizzly** HTTP Server (embedded)
- **Jackson** (JSON serialization)
- **Maven** (build tool)

---

## API Endpoints

### Discovery
- `GET /api/v1` - API metadata and available resources

### Workspaces
- `GET /api/v1/workspaces` - Get all workspaces
- `POST /api/v1/workspaces` - Create a new workspace
- `GET /api/v1/workspaces/{workspaceId}` - Get a specific workspace
- `DELETE /api/v1/workspaces/{workspaceId}` - Delete a workspace (blocked with 409 if models exist)

### Models
- `GET /api/v1/models` - Get all models
- `GET /api/v1/models?status={status}` - Filter models by status
- `GET /api/v1/models/{modelId}` - Get a specific model
- `POST /api/v1/models` - Create a new model

### Evaluation Metrics
- `GET /api/v1/models/{modelId}/metrics` - Get metric history for a model
- `POST /api/v1/models/{modelId}/metrics` - Add a new metric (blocked with 403 if DEPRECATED)

---

## Business Rules

- A workspace with assigned models **cannot be deleted** (409 Conflict)
- A model must link to an **existing workspace** when created (422 Unprocessable Entity)
- A **DEPRECATED** model cannot receive new evaluation metrics (403 Forbidden)
- Posting a new metric automatically **updates the model's latestAccuracy**

---

## Build & Run (No Server Installation Required)

```bash
# 1. Clone the repository
git clone https://github.com/ksanithiamalja/Client-Server-Coursework-5COSC022W.git

# 2. Navigate to project folder
cd Client-Server-Coursework-5COSC022W/CSACoursework

# 3. Build the project
mvn clean install

# 4. Run the server
mvn exec:java
```

The API will start on port 8080. Open in browser or Postman:# MLOps Pipeline Management API

A RESTful API built with **JAX-RS (Jersey)** and **Grizzly HTTP Server** for managing Machine Learning Workspaces, Models, and Evaluation Metrics.

---

## Technology Stack

- **Java 11**
- **JAX-RS** (Jersey 3.1.3)
- **Grizzly** HTTP Server (embedded)
- **Jackson** (JSON serialization)
- **Maven** (build tool)

---

## API Endpoints

### Discovery
- `GET /api/v1` - API metadata and available resources

### Workspaces
- `GET /api/v1/workspaces` - Get all workspaces
- `POST /api/v1/workspaces` - Create a new workspace
- `GET /api/v1/workspaces/{workspaceId}` - Get a specific workspace
- `DELETE /api/v1/workspaces/{workspaceId}` - Delete a workspace (blocked with 409 if models exist)

### Models
- `GET /api/v1/models` - Get all models
- `GET /api/v1/models?status={status}` - Filter models by status
- `GET /api/v1/models/{modelId}` - Get a specific model
- `POST /api/v1/models` - Create a new model

### Evaluation Metrics
- `GET /api/v1/models/{modelId}/metrics` - Get metric history for a model
- `POST /api/v1/models/{modelId}/metrics` - Add a new metric (blocked with 403 if DEPRECATED)

---

## Business Rules

- A workspace with assigned models **cannot be deleted** (409 Conflict)
- A model must link to an **existing workspace** when created (422 Unprocessable Entity)
- A **DEPRECATED** model cannot receive new evaluation metrics (403 Forbidden)
- Posting a new metric automatically **updates the model's latestAccuracy**

---

## Build & Run (No Server Installation Required)

```bash
# 1. Clone the repository
git clone https://github.com/ksanithiamalja/Client-Server-Coursework-5COSC022W.git

# 2. Navigate to project folder
cd Client-Server-Coursework-5COSC022W/CSACoursework

# 3. Build the project
mvn clean install

# 4. Run the server
mvn exec:java
```

The API will start on port 8080. Open in browser or Postman:# MLOps Pipeline Management API

A RESTful API built with **JAX-RS (Jersey)** and **Grizzly HTTP Server** for managing Machine Learning Workspaces, Models, and Evaluation Metrics.

---

## Technology Stack

- **Java 11**
- **JAX-RS** (Jersey 3.1.3)
- **Grizzly** HTTP Server (embedded)
- **Jackson** (JSON serialization)
- **Maven** (build tool)

---

## API Endpoints

### Discovery
- `GET /api/v1` - API metadata and available resources

### Workspaces
- `GET /api/v1/workspaces` - Get all workspaces
- `POST /api/v1/workspaces` - Create a new workspace
- `GET /api/v1/workspaces/{workspaceId}` - Get a specific workspace
- `DELETE /api/v1/workspaces/{workspaceId}` - Delete a workspace (blocked with 409 if models exist)

### Models
- `GET /api/v1/models` - Get all models
- `GET /api/v1/models?status={status}` - Filter models by status
- `GET /api/v1/models/{modelId}` - Get a specific model
- `POST /api/v1/models` - Create a new model

### Evaluation Metrics
- `GET /api/v1/models/{modelId}/metrics` - Get metric history for a model
- `POST /api/v1/models/{modelId}/metrics` - Add a new metric (blocked with 403 if DEPRECATED)

---

## Business Rules

- A workspace with assigned models **cannot be deleted** (409 Conflict)
- A model must link to an **existing workspace** when created (422 Unprocessable Entity)
- A **DEPRECATED** model cannot receive new evaluation metrics (403 Forbidden)
- Posting a new metric automatically **updates the model's latestAccuracy**

---

## Build & Run (No Server Installation Required)

```bash
# 1. Clone the repository
git clone https://github.com/ksanithiamalja/Client-Server-Coursework-5COSC022W.git

# 2. Navigate to project folder
cd Client-Server-Coursework-5COSC022W/CSACoursework

# 3. Build the project
mvn clean install

# 4. Run the server
mvn exec:java
```

The API will start on port 8080. Open in browser or Postman:http://localhost:8080/api/v1

To stop: press `Ctrl + C`

---

## Sample curl Commands

**1. Discovery**
```bash
curl -X GET http://localhost:8080/api/v1
```

**2. Get All Workspaces**
```bash
curl -X GET http://localhost:8080/api/v1/workspaces
```

**3. Get Specific Workspace**
```bash
curl -X GET http://localhost:8080/api/v1/workspaces/WSVISION-01
```

**4. Create New Workspace**
```bash
curl -X POST http://localhost:8080/api/v1/workspaces -H "Content-Type: application/json" -d "{\"id\":\"WSTEST-01\",\"teamName\":\"Test Team\",\"storageQuotaGb\":100}"
```

**5. Delete Workspace**
```bash
curl -X DELETE http://localhost:8080/api/v1/workspaces/WSTEST-01
```

**6. Get All Models**
```bash
curl -X GET http://localhost:8080/api/v1/models
```

**7. Filter Models by Status**
```bash
curl -X GET "http://localhost:8080/api/v1/models?status=DEPLOYED"
```

**8. Create New Model**
```bash
curl -X POST http://localhost:8080/api/v1/models -H "Content-Type: application/json" -d "{\"framework\":\"TensorFlow\",\"status\":\"TRAINING\",\"latestAccuracy\":0.85,\"workspaceId\":\"WSVISION-01\"}"
```

**9. Get Metrics for a Model**
```bash
curl -X GET http://localhost:8080/api/v1/models/MOD-001/metrics
```

**10. Add Metric to a Model**
```bash
curl -X POST http://localhost:8080/api/v1/models/MOD-001/metrics -H "Content-Type: application/json" -d "{\"accuracyScore\":0.97}"
```

---

## Answers to Questions

### Part 1: Service Architecture & Setup

**Q1: Explain the role of a MessageBodyWriter or a JSON provider (like Jackson) in the conversion process.**

When a Java method returns an object like `MLWorkspace`, HTTP cannot send it directly because HTTP only understands text. **Jackson** acts as a `MessageBodyWriter` — it automatically converts Java objects into JSON format. For example, when `getAllWorkspaces()` returns a `List<MLWorkspace>`, Jackson converts it into:
```json
[{"id":"WSVISION-01","teamName":"Computer Vision Lab","storageQuotaGb":500}]
```
Without Jackson, we would have to manually write JSON strings every time, which would be error-prone and time-consuming.

**Q2: Define statelessness and explain why it makes cloud APIs easier to scale horizontally.**

Statelessness means the server stores **no information** about previous requests. Every request must contain all the information needed to process it — the server treats each request as completely independent. This makes horizontal scaling easy because **any server in a cluster can handle any request** — there is no session data tied to one specific server. You can simply add more servers and distribute requests freely without worrying about which server handled the previous request.

---

### Part 2: Workspace Management

**Q 2.1: Discuss how implementing HTTP Cache-Control headers could improve performance.**

`Cache-Control` headers tell the client how long to store a response before requesting it again. For example, adding `Cache-Control: max-age=60` to `GET /api/v1/workspaces` means clients reuse the cached response for 60 seconds instead of sending a new request every time. This **reduces unnecessary server load** because the same data is not fetched repeatedly when it has not changed. For workspace lists that do not change frequently, this is a significant performance improvement.

**Q 2.2: Which HTTP method should a client use to verify a workspace exists without downloading the body?**

The client should use the **HEAD** method. `HEAD` works exactly like `GET` but the server returns **only the HTTP headers without the response body**. If the workspace exists the server returns `200 OK` with no body. If it does not exist it returns `404 Not Found` with no body. This saves bandwidth because no JSON data is transferred — the client only needs to check the status code.

---

### Part 3: Model Operations & Linking

**Q 3.1: Discuss the security and data integrity reasons why the server should generate the unique ID.**

If the client generates the ID, several problems arise:
- A malicious client could send an **existing ID** and overwrite someone else's data
- Clients could send **duplicate IDs** causing data conflicts
- Clients could send IDs in an **unexpected format** breaking the system

By generating the ID on the server using `UUID.randomUUID()`, we guarantee uniqueness, prevent tampering, and maintain full control over the ID format. The server is the **trusted authority** — clients should not manage identifiers.

**Q 3.2: How must the client modify the URL when searching for frameworks with spaces or special characters?**

The client must **URL-encode** the special characters. Spaces become `%20` and `&` becomes `%26`. 

This encoding is necessary because URLs can only contain a limited set of characters. Spaces and `&` have special meanings in URLs — `&` separates query parameters — so they must be encoded to avoid breaking the URL structure.

---

### Part 4: Deep Nesting with Sub-Resources

**Q 4.1: What is the benefit of class-level @Produces and how does method-level overriding work?**

Placing `@Produces(MediaType.APPLICATION_JSON)` at the **class level** means every method in that class automatically produces JSON without repeating the annotation on each method. This follows the **DRY principle** (Don't Repeat Yourself) and keeps the code clean. Method-level overriding works by placing a different `@Produces` annotation on a specific method — JAX-RS uses the **method-level annotation instead of the class-level one** for that specific method only. For example a class produces JSON by default but one method could override with `@Produces(MediaType.TEXT_PLAIN)` to return plain text.

---

### Part 5: Advanced Error Handling

**Q 5.1: Why must a validation failure caused by a non-existent workspaceId return a 4xx code rather than 5xx?**

HTTP status codes are categorised by **who caused the error**:
- **4xx** = the **CLIENT** made a mistake (bad request)
- **5xx** = the **SERVER** made a mistake (internal crash)

When a client sends a non-existent `workspaceId`, it is entirely the **client's fault** for providing wrong data. The server is working perfectly — it correctly detected the invalid input and rejected it. Therefore `422 Unprocessable Entity` (a 4xx code) is correct. A 5xx code would wrongly suggest the server crashed, misleading the client into thinking it was not their fault.

**Q 5.2: How does JAX-RS determine which mapper to execute when both specific and global mappers exist?**

JAX-RS always uses the **most specific ExceptionMapper** available. When an exception is thrown, JAX-RS looks for a mapper that matches the **exact exception type first**. For example if `LinkedWorkspaceNotFoundException` is thrown, JAX-RS finds `LinkedWorkspaceNotFoundExceptionMapper` and uses it. The `GlobalExceptionMapper` which implements `ExceptionMapper<Throwable>` is only used as a **last resort** when no specific mapper matches. This is called **specificity resolution** — more specific types always win over more general ones.

**Q 5.3: List two pieces of crucial HTTP metadata from ContainerRequestContext and ContainerResponseContext for debugging.**

From `ContainerRequestContext`:
1. `requestContext.getMethod()` — the HTTP method (`GET`, `POST`, `DELETE`). Tells us what operation was attempted.
2. `requestContext.getUriInfo().getRequestUri()` — the full request URI. Tells us exactly which endpoint was called.

From `ContainerResponseContext`:
1. `responseContext.getStatus()` — the HTTP status code returned (`200`, `404`, `500`). Immediately tells us if the request succeeded or failed.
2. `responseContext.getHeaders()` — the response headers. Can reveal content type issues or missing headers that caused client-side problems.
