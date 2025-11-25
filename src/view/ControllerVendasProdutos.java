/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.LgsVendasproduto;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author
 */
public class ControllerVendasProdutos extends AbstractTableModel {

    private List lstVendasProdutos;

    public void setList(List lstVendasProdutos) {
        this.lstVendasProdutos = lstVendasProdutos;
        this.fireTableDataChanged();
    }
    
    public LgsVendasproduto getBean(int rowIndex) {
        return (LgsVendasproduto) lstVendasProdutos.get(rowIndex);
    }

    public void addBean(LgsVendasproduto vendasProdutos) {
        lstVendasProdutos.add(vendasProdutos);
        this.fireTableDataChanged();
    }
    
    public void removeBean(int rowIndex) {
        lstVendasProdutos.remove(rowIndex);
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return lstVendasProdutos.size();                
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        LgsVendasproduto vendasProdutos = (LgsVendasproduto) lstVendasProdutos.get( rowIndex);
        if ( columnIndex == 0 ){
            return vendasProdutos.getLgsProduto().getLgsIdProduto();
        } else if (columnIndex ==1) {
            return vendasProdutos.getLgsProduto().getLgsNome();
        } else if (columnIndex ==2) {
            return vendasProdutos.getLgsQuantidadeProduto();
        } else if (columnIndex ==3) {
            return vendasProdutos.getLgsValorUnitario();
        }else if (columnIndex ==4) {
            return vendasProdutos.getLgsValorUnitario()*vendasProdutos.getLgsQuantidadeProduto();
        }
        return ""; 
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Produto";         
        } else if ( columnIndex == 2) {
            return "Quantidade";
        } else if ( columnIndex == 3) {
            return "Valor Unitário";
        } else if ( columnIndex == 4) {
            return "Total";
        } 
        return "";
    }
}
