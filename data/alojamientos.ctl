load data 
infile 'alojamientos.csv' "str '\r\n'"
append
into table ALOJAMIENTO
fields terminated by ','
OPTIONALLY ENCLOSED BY '"' AND '"'
trailing nullcols
           ( ID,
             PRECIO,
             CAPACIDAD,
             DTYPE CHAR(10)
           )
