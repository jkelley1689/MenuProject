/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_client;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

/**
 *
 * @author yesah
 */
public class DBClient {
    static final String userName="jkelle23";//put your MySQL user name
    static final String password="Cosc*fhnf";//put your MySQL password
    private static Connection connection=null;
    private String tempString = null;
    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws java.sql.SQLException
     */

    /**
     * @param args the command line arguments
     */
   
    
    protected void dbSet(String sql) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //"select * from shongdb.staff;"
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/jkelle23db", userName, password);// Please use your database name here
        PreparedStatement updateStaff;
        Statement queryStatement = connection.createStatement();
        updateStaff = null;
        String querys= sql; 
        updateStaff = connection.prepareStatement(querys);
        updateStaff.executeUpdate();
            
        
        
        // TODO code application logic here
    }
    
    
        protected String dbGetCustomer(String sql) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //"select * from shongdb.staff;"
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/jkelle23db", userName, password);// Please use your database name here
        PreparedStatement updateStaff;
        Statement queryStatement = connection.createStatement();
        updateStaff = null;
        
        String querys = sql;
        ResultSet results = queryStatement.executeQuery(querys);
            
        
        
        String temp = new String();
        while(results.next())
            {
                temp += (results.getString("CustomerName")+",   "+results.getString("CustomerAddress")+",   "+results.getString("CustomerEmail")+",   "+results.getString("CustomerPhone") +"\n\n");
            }   
       //    String[] result = (String[]) temp.toArray();
           return temp;
        
        
        // TODO code application logic here
    }

        
        protected String dbGetEmployee(String sql) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //"select * from shongdb.staff;"
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/jkelle23db", userName, password);// Please use your database name here
        PreparedStatement updateStaff;
        Statement queryStatement = connection.createStatement();
        updateStaff = null;
        
        String querys = sql;
        ResultSet results = queryStatement.executeQuery(querys);
            
        
        
        String temp = "First Name,          Last Name,          ,Middle Initial,          SSN,           Email,                     Phone,           "
                + "Address,                    Salary,           MGR SSN,          Store #,          \n"
                + "-----------------------------------------------------------------------------------------------------------------------------------"
                + "----------------------------------------------------------------------------------\n";
        int counter = 1;
        while(results.next())
            {
                temp += (results.getString(1)+",          "+results.getString(2)+",          "+results.getString(3)+",          "+results.getString(4)+",          "+results.getString(5)
                        +",                    "+results.getString(6)+",          "+results.getString(7)+",                     "+results.getString(8)+",          "+results.getString(9)
                        +",          "+results.getString(10)+",           "+results.getString(11)+"\n\n");
            }   
       //    String[] result = (String[]) temp.toArray();
           return temp;
        
        
        // TODO code application logic here
    }
    protected String getDBWiz(String sql){
      String result = new String();

      try{
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/jkelle23db", userName, password);// Please use your database name here
        Statement queryStatement = connection.createStatement();
        
        ResultSet results = queryStatement.executeQuery(sql);
        ResultSetMetaData rsmd = results.getMetaData();
        int size = rsmd.getColumnCount();
        while(results.next())
        {
            for(int i = 1; i < size;i++){
                result += rsmd.getColumnLabel(i);
                result += ":  ";
                result+=(results.getString(i) + ",   \n");
             } 
            result += "\n";
        }  
      }catch(Exception om){
                
      }
      return result;
    }
    
    protected ResultSet getDBWizRS(String sql){
      String result = new String();
      ResultSet results = new ResultSet() {
          @Override
          public boolean next() throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void close() throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public boolean wasNull() throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public String getString(int columnIndex) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public boolean getBoolean(int columnIndex) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public byte getByte(int columnIndex) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public short getShort(int columnIndex) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public int getInt(int columnIndex) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public long getLong(int columnIndex) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public float getFloat(int columnIndex) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public double getDouble(int columnIndex) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public BigDecimal getBigDecimal(int columnIndex, int scale) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public byte[] getBytes(int columnIndex) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Date getDate(int columnIndex) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Time getTime(int columnIndex) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Timestamp getTimestamp(int columnIndex) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public InputStream getAsciiStream(int columnIndex) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public InputStream getUnicodeStream(int columnIndex) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public InputStream getBinaryStream(int columnIndex) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public String getString(String columnLabel) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public boolean getBoolean(String columnLabel) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public byte getByte(String columnLabel) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public short getShort(String columnLabel) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public int getInt(String columnLabel) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public long getLong(String columnLabel) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public float getFloat(String columnLabel) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public double getDouble(String columnLabel) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public BigDecimal getBigDecimal(String columnLabel, int scale) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public byte[] getBytes(String columnLabel) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Date getDate(String columnLabel) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Time getTime(String columnLabel) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Timestamp getTimestamp(String columnLabel) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public InputStream getAsciiStream(String columnLabel) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public InputStream getUnicodeStream(String columnLabel) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public InputStream getBinaryStream(String columnLabel) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public SQLWarning getWarnings() throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void clearWarnings() throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public String getCursorName() throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public ResultSetMetaData getMetaData() throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Object getObject(int columnIndex) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Object getObject(String columnLabel) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public int findColumn(String columnLabel) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Reader getCharacterStream(int columnIndex) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Reader getCharacterStream(String columnLabel) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public BigDecimal getBigDecimal(int columnIndex) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public BigDecimal getBigDecimal(String columnLabel) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public boolean isBeforeFirst() throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public boolean isAfterLast() throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public boolean isFirst() throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public boolean isLast() throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void beforeFirst() throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void afterLast() throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public boolean first() throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public boolean last() throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public int getRow() throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public boolean absolute(int row) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public boolean relative(int rows) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public boolean previous() throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void setFetchDirection(int direction) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public int getFetchDirection() throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void setFetchSize(int rows) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public int getFetchSize() throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public int getType() throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public int getConcurrency() throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public boolean rowUpdated() throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public boolean rowInserted() throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public boolean rowDeleted() throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateNull(int columnIndex) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateBoolean(int columnIndex, boolean x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateByte(int columnIndex, byte x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateShort(int columnIndex, short x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateInt(int columnIndex, int x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateLong(int columnIndex, long x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateFloat(int columnIndex, float x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateDouble(int columnIndex, double x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateBigDecimal(int columnIndex, BigDecimal x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateString(int columnIndex, String x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateBytes(int columnIndex, byte[] x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateDate(int columnIndex, Date x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateTime(int columnIndex, Time x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateTimestamp(int columnIndex, Timestamp x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateAsciiStream(int columnIndex, InputStream x, int length) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateBinaryStream(int columnIndex, InputStream x, int length) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateCharacterStream(int columnIndex, Reader x, int length) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateObject(int columnIndex, Object x, int scaleOrLength) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateObject(int columnIndex, Object x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateNull(String columnLabel) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateBoolean(String columnLabel, boolean x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateByte(String columnLabel, byte x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateShort(String columnLabel, short x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateInt(String columnLabel, int x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateLong(String columnLabel, long x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateFloat(String columnLabel, float x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateDouble(String columnLabel, double x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateBigDecimal(String columnLabel, BigDecimal x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateString(String columnLabel, String x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateBytes(String columnLabel, byte[] x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateDate(String columnLabel, Date x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateTime(String columnLabel, Time x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateTimestamp(String columnLabel, Timestamp x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateAsciiStream(String columnLabel, InputStream x, int length) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateBinaryStream(String columnLabel, InputStream x, int length) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateCharacterStream(String columnLabel, Reader reader, int length) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateObject(String columnLabel, Object x, int scaleOrLength) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateObject(String columnLabel, Object x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void insertRow() throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateRow() throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void deleteRow() throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void refreshRow() throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void cancelRowUpdates() throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void moveToInsertRow() throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void moveToCurrentRow() throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Statement getStatement() throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Object getObject(int columnIndex, Map<String, Class<?>> map) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Ref getRef(int columnIndex) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Blob getBlob(int columnIndex) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Clob getClob(int columnIndex) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Array getArray(int columnIndex) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Object getObject(String columnLabel, Map<String, Class<?>> map) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Ref getRef(String columnLabel) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Blob getBlob(String columnLabel) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Clob getClob(String columnLabel) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Array getArray(String columnLabel) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Date getDate(int columnIndex, Calendar cal) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Date getDate(String columnLabel, Calendar cal) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Time getTime(int columnIndex, Calendar cal) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Time getTime(String columnLabel, Calendar cal) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Timestamp getTimestamp(int columnIndex, Calendar cal) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Timestamp getTimestamp(String columnLabel, Calendar cal) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public URL getURL(int columnIndex) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public URL getURL(String columnLabel) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateRef(int columnIndex, Ref x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateRef(String columnLabel, Ref x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateBlob(int columnIndex, Blob x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateBlob(String columnLabel, Blob x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateClob(int columnIndex, Clob x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateClob(String columnLabel, Clob x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateArray(int columnIndex, Array x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateArray(String columnLabel, Array x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public RowId getRowId(int columnIndex) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public RowId getRowId(String columnLabel) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateRowId(int columnIndex, RowId x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateRowId(String columnLabel, RowId x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public int getHoldability() throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public boolean isClosed() throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateNString(int columnIndex, String nString) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateNString(String columnLabel, String nString) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateNClob(int columnIndex, NClob nClob) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateNClob(String columnLabel, NClob nClob) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public NClob getNClob(int columnIndex) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public NClob getNClob(String columnLabel) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public SQLXML getSQLXML(int columnIndex) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public SQLXML getSQLXML(String columnLabel) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateSQLXML(int columnIndex, SQLXML xmlObject) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateSQLXML(String columnLabel, SQLXML xmlObject) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public String getNString(int columnIndex) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public String getNString(String columnLabel) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Reader getNCharacterStream(int columnIndex) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public Reader getNCharacterStream(String columnLabel) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateNCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateNCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateAsciiStream(int columnIndex, InputStream x, long length) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateBinaryStream(int columnIndex, InputStream x, long length) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateAsciiStream(String columnLabel, InputStream x, long length) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateBinaryStream(String columnLabel, InputStream x, long length) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateBlob(int columnIndex, InputStream inputStream, long length) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateBlob(String columnLabel, InputStream inputStream, long length) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateClob(int columnIndex, Reader reader, long length) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateClob(String columnLabel, Reader reader, long length) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateNClob(int columnIndex, Reader reader, long length) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateNClob(String columnLabel, Reader reader, long length) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateNCharacterStream(int columnIndex, Reader x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateNCharacterStream(String columnLabel, Reader reader) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateAsciiStream(int columnIndex, InputStream x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateBinaryStream(int columnIndex, InputStream x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateCharacterStream(int columnIndex, Reader x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateAsciiStream(String columnLabel, InputStream x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateBinaryStream(String columnLabel, InputStream x) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateCharacterStream(String columnLabel, Reader reader) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateBlob(int columnIndex, InputStream inputStream) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateBlob(String columnLabel, InputStream inputStream) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateClob(int columnIndex, Reader reader) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateClob(String columnLabel, Reader reader) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateNClob(int columnIndex, Reader reader) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void updateNClob(String columnLabel, Reader reader) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public <T> T getObject(int columnIndex, Class<T> type) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public <T> T getObject(String columnLabel, Class<T> type) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public <T> T unwrap(Class<T> iface) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public boolean isWrapperFor(Class<?> iface) throws SQLException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }
      };

      try{
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/jkelle23db", userName, password);// Please use your database name here
        Statement queryStatement = connection.createStatement();
        
        results = queryStatement.executeQuery(sql);
        ResultSetMetaData rsmd = results.getMetaData();
        int size = rsmd.getColumnCount();
        
      }catch(Exception om){
                
      }
      return results;
    }

    protected String sendString(String temp){
        tempString = temp;
        return tempString;
    }
    
    
}
