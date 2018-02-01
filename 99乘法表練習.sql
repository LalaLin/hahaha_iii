create procedure loop99(@i1 int,@j1 int) as
begin
declare @i int,@j int,@str varchar(200)
set @str = ''
set @i =1
while (@i<=@i1)
begin
	set @j =1
	set @str = ''
	while (@j <=@j1)
	begin
		--set  @str += (convert(varchar(5),@i) + '*' +convert(varchar(5),@j) + '=' + convert(varchar(5),@i*@j)+ ' ')
		set @str += format(@i,'00') + '*' + format(@j,'00') + '=' + format(@i*@j,'00') + CHAR(9)
		set @j+=1
	end
	print @str
	set @i+=1

end
end