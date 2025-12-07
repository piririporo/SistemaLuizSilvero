/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.LgsVendas;
import bean.LgsProduto;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Luiz
 */
public class ControllerConsultasProdutos extends AbstractTableModel {

    private List lstProdutos;

    public void setList(List lstProdutos) {
        this.lstProdutos = lstProdutos;
        this.fireTableDataChanged();
    }
    
//    public Pedidos getBean(int rowIndex) {
//        return (Pedidos) lstProdutos.get(rowIndex);
//    }

    @Override
    public int getRowCount() {
        return lstProdutos.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        LgsProduto produtos = (LgsProduto) lstProdutos.get( rowIndex);
               if (columnIndex == 0 ) {
            return produtos.getLgsIdProduto();
        }else if (columnIndex ==1) {
            return produtos.getLgsIngredientes();   
        }else if (columnIndex ==2) {
            return produtos.getLgsNome();        
        } else if (columnIndex ==3) {
            return produtos.getLgsPreco();
        }
        return ""; 
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Ingredientes";         
        }else if ( columnIndex == 2) {
            return "Nome";         
        } else if ( columnIndex == 3) {
            return "Valor Unitário";
        } 
        return "";
    }
}
