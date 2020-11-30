SELECT r.rolname as username, r1.rolname as userrole
FROM pg_catalog.pg_roles r
JOIN pg_catalog.pg_auth_members m
ON (m.member = r.oid)
JOIN pg_roles r1
ON (m.roleid = r1.oid)
WHERE r.rolcanlogin AND r.rolname = current_user;