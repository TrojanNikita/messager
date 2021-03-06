package io.trojan.user

import endpoints4s.algebra.circe.JsonEntitiesFromCodecs

trait UserApiAlg extends JsonEntitiesFromCodecs {
  type RequestId = String

  private val urlGetUsers          = path / "api" / "users"
  private val urlPostUser          = path / "api" / "users"

  protected val getUsersApi: Endpoint[Unit, List[User]] = endpoint(
    get(urlGetUsers),
    ok(jsonResponse[List[User]])
  )

  protected val postUserApi: Endpoint[User, Long] = endpoint(
    post(urlPostUser, entity = jsonRequest[User]),
    ok(jsonResponse[Long])
  )

  protected val deleteUserApi: Endpoint[Unit, Unit] = endpoint(
    delete(urlPostUser),
    ok(emptyResponse)
  )
}

