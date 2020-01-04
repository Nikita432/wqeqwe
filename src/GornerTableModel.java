import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class GornerTableModel extends AbstractTableModel {
    private Double[] coefficients;
    private Double from;
    private Double to;
    private Double step;

    public GornerTableModel(Double from, Double to, Double step, Double[] coefficients) {
        this.from = from;
        this.to = to;
        this.step = step;
        this.coefficients = coefficients;
    }

    public Double getFrom() {
        return from;
    }

    public Double getTo() {
        return to;
    }

    public Double getStep() {
        return step;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
        return new Double(Math.ceil((to - from) / step)).intValue() + 1;
    }

    @Override
    public Object getValueAt(int row, int col)
    {
        double x = from + step * row;
        if (col == 0)
            return x;
        else
        {
            Double result = coefficients[0];
            for (int i = 0; i < coefficients.length-1; i++)
                result = result*x + coefficients[++i];
            return result;
        }
    }

    public String getColumnName(int col)
    {
        switch (col)
        {
            case 0:
                return "Значение X";
            case 1:
                return "Значение многочлена";
            default:
                return "Точное значение?";
        }
    }

    public Class<?> getColumnClass(int col)
    { return Double.class; }
}
