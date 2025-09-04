# 📝 To-Do List API

간단한 To-Do List 애플리케이션입니다.  
사용자가 할 일을 등록, 조회, 수정, 삭제할 수 있는 REST API를 제공합니다.  

---

## 📖 기능 요구사항
- [x] 할 일 등록 (Create)
- [x] 전체 할 일 조회 (Read)
- [x] 특정 할 일 조회 (Read by id) 
- [x] 할 일 완료 여부 수정 (Update)
- [x] 할 일 삭제 (Delete)

---

## 🗂 데이터 모델
**Todo**
- `id` (Long, PK)
- `task` (String) : 할 일 내용
- `completed` (boolean) : 완료 여부
- `createdAt` (LocalDateTime) : 생성 시간

---

## 📡 API 명세

| Method   | Endpoint      | Description             | Request Params / Body       | Response 예시 |
|----------|---------------|-------------------------|-----------------------------|----------------|
| `POST`   | `/todos`      | 할 일 등록              | `task` (String)             | `Todo 객체` |
| `GET`    | `/todos`      | 전체 할 일 조회         | -                           | `[Todo, Todo...]` |
| `GET`    | `/todos/{id}` | 특정 할 일 조회         | PathVariable: id            | `Todo 객체` |
| `PUT`    | `/todos/{id}` | 할 일 완료 여부 수정    | PathVariable: id, QueryParam: completed | `Todo 객체` |
| `DELETE` | `/todos/{id}` | 할 일 삭제              | PathVariable: id            | 성공 여부 |

---

## 📌 예시 요청 & 응답

### ➕ 할 일 등록
```http
POST /todos?task=공부하기
