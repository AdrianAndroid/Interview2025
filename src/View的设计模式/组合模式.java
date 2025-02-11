package View的设计模式;

import javax.naming.Context;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.Position;
import java.awt.*;

public class 组合模式 {

    class ViewGroup extends View {

        public ViewGroup(Context context) {
            super(context);
        }
    }
    class LinearLayout extends ViewGroup {

        public LinearLayout(Context context) {
            super(context);
        }
    }

    class View extends javax.swing.text.View {



        /**
         * Creates a new <code>View</code> object.
         *
         * @param elem the <code>Element</code> to represent
         */
        public View(Element elem) {
            super(elem);
        }

        public View(Context context) {
            super(null);
        }

        @Override
        public float getPreferredSpan(int axis) {
            return 0;
        }

        @Override
        public void paint(Graphics g, Shape allocation) {

        }

        @Override
        public Shape modelToView(int pos, Shape a, Position.Bias b) throws BadLocationException {
            return null;
        }

        @Override
        public int viewToModel(float x, float y, Shape a, Position.Bias[] biasReturn) {
            return 0;
        }
    }

    // 抽象组件
    abstract class Component {
        protected Context context;

        public Component(Context context) {
            this.context = context;
        }
        public abstract View getView();
    }

    // 叶子节点：View
    class LeafView extends Component {
        private View view;

        public LeafView(Context context) {
            super(context);
            view = new View(context);
        }

        @Override
        public View getView() {
            return view;
        }
    }

    // 容器节点：ViewGroup
    class CompositeViewGroup extends Component {
        private ViewGroup viewGroup;

        public CompositeViewGroup(Context context) {
            super(context);
            viewGroup = new LinearLayout(context);
        }

        public void addComponent(Component component) {
            // viewGroup.addView(component.getView());
        }

        @Override
        public View getView() {
            return viewGroup;
        }
    }

    public static void main(String[] args) {
//        Context context = null;
//        CompositeViewGroup root = new CompositeViewGroup(context);
//        LeafView leaf1 = new LeafView(context);
//        LeafView leaf2 = new LeafView(context);
//        root.addComponent(leaf1);
//        root.addComponent(leaf2);
    }
}
