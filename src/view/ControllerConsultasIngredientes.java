/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.LgsVendas;
import bean.LgsIngredientes;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Luiz
 */
public class ControllerConsultasIngredientes extends AbstractTableModel {

    private List lstIngredientes;

    public void setList(List lstIngredientes) {
        this.lstIngredientes = lstIngredientes;
        this.fireTableDataChanged();
    }
    
//    public Pedidos getBean(int rowIndex) {
//        return (Pedidos) lstIngredientes.get(rowIndex);
//    }

    @Override
    public int getRowCount() {
        return lstIngredientes.size();
                
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        LgsIngredientes ingredientes = (LgsIngredientes) lstIngredientes.get( rowIndex);
               if (columnIndex == 0 ) {
            return ingredientes.getLgsIdIngredientes();
        }else if (columnIndex ==1) {
            return ingredientes.getLgsNome();   
        }else if (columnIndex ==2) {
            return ingredientes.getLgsQuantidadeEstoque();        
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
            return "Quantidade no estoque";         
        } 
        return "";
    }
}
