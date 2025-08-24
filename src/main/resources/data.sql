INSERT INTO users (
  email
, password
, username
, birth
, create_at
) VALUES
  ("userA@handscope.kr", "userA123", "userA", now(), now())
, ("userB@handscope.kr", "userB123", "userB", now(), now())
, ("userC@handscope.kr", "userC123", "userC", now(), now())
, ("userD@handscope.kr", "userD123", "userD", now(), now())
, ("userE@handscope.kr", "userE123", "userE", now(), now());

INSERT INTO measurement(
  user_id
, measurement_at
, score
, description
, create_at
, create_by
) VALUES
  (1, now(), 100, "매우 건강", now(), now())
, (2, now(), 90 , "건강", now(), now())
, (3, now(), 80 , "평균", now(), now())
, (4, now(), 70 , "주의", now(), now())
, (5, now(), 60 , "위험", now(), now())