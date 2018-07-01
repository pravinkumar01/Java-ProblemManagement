package application.frames;

import application.exceptions.ManagerException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class ResourceProvider {

    protected final Connection getDatabaseConnection(String databaseName) throws ManagerException{
        try{
            Connection connection = null;
            if(this.compareString(databaseName, "E2ETracker")){
                Class.forName("oracle.jdbc.driver.OracleDriver");
                connection=DriverManager.getConnection("jdbc:oracle:thin:@FMT01D:1540:FMT01D","test_user","test_password");
            }else if(this.compareString(databaseName, "HPSM")){
            	Class.forName("oracle.jdbc.driver.OracleDriver");
                connection=DriverManager.getConnection("jdbc:oracle:thin:@SCE01P:1540:SCE01P","test_user","test_user");
                connection.setReadOnly(true);
            }else if(this.compareString(databaseName, "QCT")){
            	Class.forName("oracle.jdbc.driver.OracleDriver");
                connection=DriverManager.getConnection("jdbc:oracle:thin:@TDIP:1540:TDIP","test_user","test_user");
                connection.setReadOnly(true);
            }
            return connection;
        }catch(ClassNotFoundException eClass){
            throw new ManagerException(1000, "E", "Database Error", "Error occured during database operation. Please contact System Administrator.");
        }catch(SQLException eSQL){
            throw new ManagerException(1000, "E", "Database Error", "Error occured during database operation. Please contact System Administrator.");
        }catch(Exception eALL){
            throw new ManagerException(1000, "E", "Application Error", "Unknown system error. Please contact System Administrator.");
        }
    }

    protected final void closeDatabaseConnection(Connection objConnection, boolean commitFlag, boolean closeFlag) throws ManagerException{
        try{
            if (commitFlag){
                objConnection.commit();
            }else{
                objConnection.rollback();
            }

            if (closeFlag){
                objConnection.close();
            }
        }catch(SQLException eSQL){
            throw new ManagerException(1000, "E", "Database Error", "Error occured during database operation. Please contact System Administrator.");
        }catch(Exception e){
            throw new ManagerException(1000, "E", "Allpication Error", "Unknown system error. Please contact System Administrator.");
        }
    }

    protected final String getEncryptPassword(String password) throws ManagerException{
        String convertedMD5 = null;
        try{
                if (null == password){
                        return null;
                }else{
                        MessageDigest digest = MessageDigest.getInstance("MD5");
                        digest.update(password.getBytes(), 0, password.length());
                        convertedMD5 = new BigInteger(1, digest.digest()).toString(16);
                        return convertedMD5;
                }
        }catch(NoSuchAlgorithmException e){
             throw new ManagerException(1000, "E", "Application Error", "Error occured during password encryption. Please contact System Administrator.");
        }catch(Exception eAll){
            eAll.printStackTrace();
            throw new ManagerException(1000, "E", "Application Error", "Unknown system error. Please contact System Administrator.");
        }
    }

    protected final boolean generateExcelFile(List<List<String>> printDataList, String fileName) throws ManagerException{
    	try{
    		XSSFWorkbook workbook = new XSSFWorkbook();
		    XSSFSheet spreadsheet = workbook.createSheet("E2E_Issue_Details");
		    XSSFRow row;
		    XSSFFont headerFont = workbook.createFont();
		    XSSFCellStyle headerStyle = workbook.createCellStyle();
		    headerFont.setFontHeightInPoints((short) 12);
		    headerFont.setFontName("Calibri");
		    headerFont.setBold(true);
		    headerFont.setColor(HSSFColor.BLACK.index);
		    headerStyle.setFont(headerFont);
		    headerStyle.setFillForegroundColor(HSSFColor.GREY_50_PERCENT.index);
		    headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		    headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		    headerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		    headerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		    headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		    headerStyle.setAlignment(CellStyle.ALIGN_CENTER);

		    XSSFFont firstFont = workbook.createFont();
		    XSSFCellStyle firstStyle = workbook.createCellStyle();
		    firstFont.setFontHeightInPoints((short) 12);
		    firstFont.setFontName("Calibri");
		    firstFont.setBold(false);
		    firstFont.setColor(HSSFColor.BLACK.index);
		    firstStyle.setFont(firstFont);
		    firstStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		    firstStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		    firstStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		    firstStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		    firstStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		    firstStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);

		    XSSFFont secondFont = workbook.createFont();
		    XSSFCellStyle secondStyle = workbook.createCellStyle();
		    secondFont.setFontHeightInPoints((short) 12);
		    secondFont.setFontName("Calibri");
		    secondFont.setBold(false);
		    secondFont.setColor(HSSFColor.BLACK.index);
		    secondStyle.setFont(secondFont);
		    secondStyle.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
		    secondStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		    secondStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		    secondStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		    secondStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		    secondStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);

		    for(int i=0; i<printDataList.size(); i++){
		    	row = spreadsheet.createRow(i);
		    	for(int j=0; j<printDataList.get(i).size(); j++){
		    		Cell cell = row.createCell(j);
		    		if (i==0){
		    			cell.setCellStyle(headerStyle);
		    		}else if(i % 2 == 0){
		    			cell.setCellStyle(secondStyle);
		    		}else{
		    			cell.setCellStyle(firstStyle);
		    		}
		    		cell.setCellValue(printDataList.get(i).get(j));
		    	}
		    }

		    row = workbook.getSheetAt(0).getRow(0);
		    for(int colNum = 0; colNum<row.getLastCellNum();colNum++){
		    	workbook.getSheetAt(0).autoSizeColumn(colNum);
		    }

			FileOutputStream out = new FileOutputStream(new File(fileName));
			workbook.write(out);
		    out.close();
		    workbook.close();
		    return true;
		}catch(FileNotFoundException e){
			throw new ManagerException(100, "E", "Application Message", e.getMessage());
		}catch(IOException e){
			throw new ManagerException(100, "E", "Application Message", e.getMessage());
		}
    }

    public final String[] convertListToArray(List<String> inputList){
        String[] arrayString = inputList.toArray(new String[inputList.size()]);
        return arrayString;
	}

	public final List<String> convertArrayToList(String[] inputArray){
      List<String> resultList = new ArrayList<String>();
		for(int i = 0; i<inputArray.length; i++){
			resultList.add(inputArray[i]);
      }
      return resultList;
	}

	public final String[][] convertListOfListToMultiDimArray(List<List<String>> inputListOfList){
		String[][] returnMultiD = new String [inputListOfList.size()][inputListOfList.get(0).size()];

		for(int i=0; i<inputListOfList.size(); i++){
			for(int j=0; j<inputListOfList.get(0).size(); j++){
				returnMultiD[i][j] = inputListOfList.get(i).get(j);
			}
		}
		return returnMultiD;
	}

	public final boolean compareString(String firstString, String secondString){
	      String objFirstString = new String(firstString);
	      String objSecondString = new String(secondString);

	      if (objFirstString.equals(objSecondString)) {
	              return true;
	      }else{
	              return false;
	      }
	}

	public final boolean wordExistsInString(String searchKey, String searchInto){
		if(searchInto == null){
			return false;
		}else{
			if(searchInto.toLowerCase().contains(searchKey.toLowerCase())){
				return true;
			}else{
				return false;
			}
		}
	}

	public int getIndexFromList(List<String> sourceList, String inputString){
		int result = 0;
		for (int i=0; i<sourceList.size(); i++){
			if(sourceList.get(i).equalsIgnoreCase(inputString)){
				result = i;
				break;
			}
		}
		return result;
	}

	public int getIndexFromArray(String[] sourceArray, String inputString){
		int result = 0;
		for (int i=0; i<sourceArray.length; i++){
			if(sourceArray[i].equalsIgnoreCase(inputString)){
				result = i;
				break;
			}
		}
		return result;
	}

	protected boolean verifyPmId(String inputString){
		if(inputString.matches("^[PM]{2}\\d{6}") && inputString.length()==8){
			return true;
		}else{
			return false;
		}
	}

	protected boolean verifyDefectId(String inputString){
		if(inputString.matches("[0-9]+")){
			return true;
		}else{
			return false;
		}
	}

	protected boolean verifyIncidentId(String inputString){
		if(inputString.matches("^[IM]{2}\\d{7}") && inputString.length()==9){
			return true;
		}else{
			return false;
		}
	}
}
