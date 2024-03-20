-- Создание функции для триггера
create or replace function user_history_trigger_function()
    returns trigger as
$$
begin
    IF TG_OP = 'INSERT' THEN
        INSERT INTO "userhistory" (id, username, email, action_type, action_timestamp)
        VALUES (NEW.id, NEW.username, NEW.email, 'INSERT', CURRENT_TIMESTAMP);
    ELSIF TG_OP = 'UPDATE' THEN
        INSERT INTO "userhistory" (id, username, email, action_type, action_timestamp)
        VALUES (NEW.id, NEW.username, NEW.email, 'UPDATE', CURRENT_TIMESTAMP);
    ELSIF TG_OP = 'DELETE' THEN
        INSERT INTO "userhistory" (id, username, email, action_type, action_timestamp)
        VALUES (OLD.id, OLD.username, OLD.email, 'DELETE', CURRENT_TIMESTAMP);
END IF;
RETURN NEW;
END;
$$ language plpgsql;

-- Создание триггера на таблицу "User"
--CREATE TRIGGER user_history_trigger
    --AFTER INSERT OR UPDATE OR DELETE ON "user"
    --FOR EACH ROW
    --EXECUTE FUNCTION user_history_trigger_function();