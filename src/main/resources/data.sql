INSERT INTO member (
  email
, password
, username
, birth
, create_at
, role
) VALUES
  ("userA@handscope.kr", "userA123", "userA", now(), now(), "USER")
, ("userB@handscope.kr", "userB123", "userB", now(), now(), "USER")
, ("userC@handscope.kr", "userC123", "userC", now(), now(), "USER")
, ("userD@handscope.kr", "userD123", "userD", now(), now(), "USER")
, ("userE@handscope.kr", "userE123", "userE", now(), now(), "USER");

-- INSERT INTO measurement(
--   member_id
-- , measurement_at
-- , score
-- , description
-- , create_at
-- , create_by
-- ) VALUES
--   (1, now(), 100, "매우 건강", now(), now())
-- , (2, now(), 90 , "건강", now(), now())
-- , (3, now(), 80 , "평균", now(), now())
-- , (4, now(), 70 , "주의", now(), now())
-- , (5, now(), 60 , "위험", now(), now())