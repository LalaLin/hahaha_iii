create TRIGGER trig_seats 
ON    playlist
AFTER INSERT
AS
BEGIN
  DECLARE   @v_ptime   varchar(20); 
  DECLARE   @v_movie   int;
  DECLARE   @v_roomid  varchar(10);

  --�ޥηs���ȱq inserted ��� ; �L�k�����H inserted.ptime�s��
   
  SELECT @v_ptime = ptime, @v_movie = movie, @v_roomid =roomid
  FROM   inserted;
      
  --�ھ� inserted��Ĳ�o���ͪ���,�I�s �@�~2-4 �� gen_seats stored procedure

  EXEC gen_seats @v_ptime, @v_movie, @v_roomid;

END;
insert  into playlist values ('2008-12-25 13:00', 1, 'A�U') 
