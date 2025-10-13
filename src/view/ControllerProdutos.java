/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.LgsProduto;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Marcos
 */
public class ControllerProdutos extends AbstractTableModel {

    private List lstProdutos;

    public void setList(List lstUsuarios) {
        this.lstProdutos = lstUsuarios;
    }
    
    public LgsProduto getBean(int rowIndex) {
        return (LgsProduto) lstProdutos.get(rowIndex);
    }

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
        LgsProduto produto = (LgsProduto) lstProdutos.get( rowIndex);
        if ( columnIndex == 0 ){
            return produto.getLgsIdProduto();
        } else if (columnIndex ==1) {
            return produto.getLgsIngredientes();
        } else if (columnIndex ==2) {
            return produto.getLgsNome();        
        } else if (columnIndex ==3) {
            return produto.getLgsPreco();
        } 
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Ingredientes";         
        } else if ( columnIndex == 2) {
            return "Nome";
        } else if ( columnIndex == 3) {
            return "Preço";
        } 
        return "";
    }
}
