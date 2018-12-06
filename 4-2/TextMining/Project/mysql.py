import pymysql;

url = "localhost"
id='root'
password='kr1234'
dbName='bullying_defence_ai'

def init():
    global db, cursor;
    db = pymysql.connect(host=url, port=3306, user=id, passwd=password, db=dbName, charset='utf8');
    cursor = db.cursor()

def test_insert_data():
    sql = "INSERT INTO test1 (no, name, geo) VALUES('1', '파이썬에서 저장됨', '10.3')"
    print(sql)
    cursor.execute(sql)

    db.commit()
    print(cursor().lastrowid)

def insert_dataSet(tableName, data):

    sql = "INSERT INTO " + tableName +  " (coments) SELECT '"+str(data) + "' FROM DUAL WHERE NOT EXISTS (SELECT coments FROM "+tableName+" WHERE coments='"+str(data)+"')"
    print("DataSet : " + sql)
    cursor.execute(sql)

    db.commit()

def register_coments(id,coments, isbullying):
    sql = "INSERT INTO comentscotent (id, coments, isbullying) VALUES('"+ str(id) + "', '" + str(coments) + "', '" + int(isbullying)  + "')"

    print(sql)
    cursor().execute(sql)

    db.commit()

def select_dataSet(tableName) :
    cursor = db.cursor();
    sql = "select coments from " + tableName
    cursor.execute(sql)
    context = []
    # 데이타 Fetch
    rows = cursor.fetchall()
    for row in rows :
        context.append(str(row))
    # print(rows)

    return context;

def select_login() :
    cursor = db.cursor();
    sql = "select * from member"
    cursor.execute(sql)
    context = []
    rows = cursor.fetchall()
    for row in rows :
        dic = {'ID':row[0],'PW':row[1],'NAME':row[2]}
        context.append(dic)
    return context;

def select_eye_data_for_Starting(i) :
    global f, idex1;
    id1 = i
    if f:
        cursor = db.cursor();
        sql = "select idx from eyesdata WHERE ID='"+id1+"'  ORDER BY idx DESC Limit 1"
        print(sql)
        cursor.execute(sql)
        context = []
        # 데이타 Fetch
        rows = cursor.fetchall()
        for n in rows :
            idex1 = str(n[0])
        f = False;
    cursor = db.cursor();
    sql = "select DATE, TIME, COUNT from eyesdata WHERE ID='" + id1 + "' and idx >=" + idex1 + " ORDER BY idx DESC"
    print(sql)
    cursor.execute(sql)
    # 데이타 Fetch
    rows = cursor.fetchall()
    return rows;

def select_eye_data(id1) :
    cursor = db.cursor();
    sql = "select DATE, TIME, COUNT from eyesdata WHERE ID='"+id1+"'"
    print(sql)
    cursor.execute(sql)
    context = []
    # 데이타 Fetch
    rows = cursor.fetchall()

    return rows;



def select_data_boradView() :
    cursor = db.cursor();
    sql = "select idx ,ID ,DATE ,Title from board ORDER BY idx DESC"
    cursor.execute(sql)
    context = []
    # 데이타 Fetch
    rows = cursor.fetchall()
    for row in rows :
        dic = {'idx':row[0],'ID':row[1],'DATE':row[2],'Title':row[3]}
        context.append(dic)
    return context;

def select_data_boradView1(id1) :
    cursor = db.cursor();
    sql = "select idx ,ID ,DATE ,Title from board WHERE ID='"+id1+"' ORDER BY idx DESC"
    cursor.execute(sql)
    # 데이타 Fetch
    rows = cursor.fetchall()

    return rows;


def select_data_boradRead(idx, name) :
    cursor = db.cursor();
    sql = "select * from board where idx =" + str(idx)
    cursor.execute(sql)
    context = []
    # 데이타 Fetch
    rows = cursor.fetchall()
    idx_A,ID_A,DATE_A,TIME_A,Title_A, Content_A,Email_A = [],[],[],[],[],[],[];

    for row in rows :
        idx_A.append(row[0])
        ID_A.append(row[1])
        DATE_A.append(row[2])
        TIME_A.append(row[3])
        Title_A.append(row[4])
        Content_A.append(row[5])
        Email_A.append(row[7])

    dic = {'idx':idx_A,'ID':ID_A,'DATE':DATE_A, 'TIME':TIME_A, 'Title':Title_A, 'Content':Content_A, 'Email':Email_A, 'name' : name}
    context.append(dic)

    return context;

def select_bullyindTable():
    cursor = db.cursor();
    sql = "select coments from bullying"
    cursor.execute(sql)
    # 데이타 Fetch
    rows = cursor.fetchall()

    return rows
