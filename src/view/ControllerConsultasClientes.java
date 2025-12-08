/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;


import bean.LgsClientes;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Luiz
 */
public class ControllerConsultasClientes extends AbstractTableModel {

    private List lstClientes;

    public void setList(List lstClientes) {
        this.lstClientes = lstClientes;
        this.fireTableDataChanged();
    }
    
//    public Pedidos getBean(int rowIndex) {
//        return (Pedidos) lstClientes.get(rowIndex);
//    }

    @Override
    public int getRowCount() {
        return lstClientes.size();
                
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        LgsClientes clientes = (LgsClientes) lstClientes.get( rowIndex);
               if (columnIndex == 0 ) {
            return clientes.getLgsIdClientes();
        }else if (columnIndex ==1) {
            return clientes.getLgsNome();   
        }else if (columnIndex ==2) {
            return clientes.getLgsCpf();        
        } 
        return ""; 
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Nome";         
        }else if ( columnIndex == 2) {
            return "Cpf";         
        } 
        return "";
    }
}
