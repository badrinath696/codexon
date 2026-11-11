# Codexon

Codexon is a backend-focused online judge and competitive programming platform built with Java and Spring Boot.

The project currently provides APIs for managing programming problems, tags, examples, test cases, editorials, and problem browsing. Other areas such as authentication, submissions, code execution, contests, leaderboards, and discussions are still under development.

## Current Features

- Create and manage programming problems
- Create full problems with examples, test cases, tags, and editorials
- Update, patch, and delete problem-related resources
- Create problem tags
- Browse published problems with pagination, sorting, difficulty filtering, search, and tag filtering
- View problem details with public test cases and examples
- PostgreSQL persistence with Spring Data JPA
- DTO mapping with MapStruct and Lombok

## Planned Features

- Authentication and authorization
- User profile and progress tracking
- Code submission APIs
- Sandboxed code execution
- Verdict generation from judge results
- Contest management
- Leaderboards
- Discussions
- Submission analytics

## Tech Stack

- Java 25
- Spring Boot 4.1.0
- Spring Web MVC
- Spring Data JPA
- Hibernate
- PostgreSQL
- MapStruct
- Lombok
- Maven

## Project Structure

```text
src/
|-- main/
|   |-- java/
|   |   `-- com/badri/codexon/
|   |       |-- common/
|   |       |-- contest/
|   |       |-- discussion/
|   |       |-- editorial/
|   |       |-- example/
|   |       |-- judgeEngine/
|   |       |-- problem/
|   |       |-- submission/
|   |       |-- tags/
|   |       |-- testcase/
|   |       `-- user/
|   `-- resources/
|       `-- application.properties
`-- test/
    `-- java/
```

## API Overview

### Public Problem APIs

- `GET /api/v1/problems`
- `GET /api/v1/problems/{problemId}`

### Admin Tag APIs

- `POST /api/v1/admin/tag/create`

### Admin Problem APIs

- `POST /api/v1/admin/problem/create`
- `POST /api/v1/admin/problem/create/fullProblem`
- `POST /api/v1/admin/problem/{problemId}/create/examples`
- `POST /api/v1/admin/problem/{problemId}/create/testCases`
- `POST /api/v1/admin/problem/{problemId}/create/editorial`
- `POST /api/v1/admin/problem/{problemId}/create/problemTags`
- `PUT /api/v1/admin/problem/{problemId}/update/fullProblem`
- `PUT /api/v1/admin/problem/{problemId}/update/problem`
- `PUT /api/v1/admin/problem/{problemId}/update/examples`
- `PUT /api/v1/admin/problem/{problemId}/update/testCases`
- `PUT /api/v1/admin/problem/{problemId}/update/problemTags`
- `PUT /api/v1/admin/problem/{problemId}/update/editorial`
- `PATCH /api/v1/admin/problem/{problemId}/edit/problem`
- `PATCH /api/v1/admin/problem/{problemId}/edit/examples`
- `PATCH /api/v1/admin/problem/{problemId}/edit/testCases`
- `PATCH /api/v1/admin/problem/{problemId}/edit/problemTags`
- `PATCH /api/v1/admin/problem/{problemId}/edit/editoral`
- `DELETE /api/v1/admin/problem/{problemId}/delete`
- `DELETE /api/v1/admin/problem/{problemId}/example/{exampleId}/delete`
- `DELETE /api/v1/admin/problem/{problemId}/testCase/{testCaseId}/delete`
- `DELETE /api/v1/admin/problem/{problemId}/problemTag/{problemTagId}/delete`
- `DELETE /api/v1/admin/problem/{problemId}/editorial/{editorialId}/delete`

## Running Locally

### Prerequisites

- Java 25
- PostgreSQL
- Git

### Environment Variables

The application reads database configuration from environment variables:

```text
DB_URL=your_Database_URL
DB_USERNAME=your_postgres_user
DB_PASSWORD=your_postgres_password
```

### Build

```bash
./mvnw compile
```

On Windows:

```powershell
.\mvnw.cmd compile
```

### Run Tests

Tests load the Spring application context, so the database environment variables must be configured before running them.

```bash
./mvnw test
```

On Windows:

```powershell
.\mvnw.cmd test
```

### Run Application

```bash
./mvnw spring-boot:run
```

On Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

## Current Status

Codexon is under active development. The implemented backend mainly covers problem management and problem browsing. Submission handling, judge execution, authentication, contests, leaderboards, and discussions are represented in the codebase but are not complete API features yet.

