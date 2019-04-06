import java.util.NoSuchElementException;

public class CellList {
    private CellNode head;
    private int size;

    public CellList() {
        this.head = null;
        this.size = 0;
    }

    public CellList(CellList cellList){
        this.head = cellList.head;
        this.size = cellList.size;
    }

    class CellNode{
        private CellPhone cp = new CellPhone(123111212,"OnePlus",2018,500);
        private CellNode next;

        public CellNode() {
            cp = null;
            next = null;
        }

        public CellNode(CellPhone cp, CellNode next) {
            this.cp = cp;
            this.next = next;
        }

        public CellNode(CellNode cn){
            this.cp = cn.getCp();
            this.next = cn.getnext();
        }

        public CellPhone getCp() {
            return cp;
        }

        public void setCp(CellPhone cp) {
            this.cp = cp;
        }

        public CellNode getnext() {
            return next;
        }

        public void setnext(CellNode next) {
            this.next = next;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return new CellNode(this.cp, this.next);
        }
    }

    public void addToStart(CellPhone cp){
        if (find(cp.getSerialNum())==null) {
            head = new CellNode(cp, head);
            size++;
        }
    }

//    public int size(){
//        int ctr = 0;
//        CellNode temp=head;
//        if (head == null)
//            return 0;
//        while (temp.next != null){
//            temp = temp.next;
//            ctr++;
//        }
//        return ctr;
//    }

    public void insertAtIndex(CellPhone cp, int index){
        int ctr=0;
        CellNode temp = head;
        if (find(cp.getSerialNum())==null) {
            if (index > this.size - 1)
                throw new NoSuchElementException();
            if (index == 0)
                this.addToStart((CellPhone) cp.clone());
            while (temp.next != null && ctr + 1 != index) {
                temp = temp.next;
                ctr++;
            }
            temp.next = new CellNode((CellPhone) cp.clone(), temp.next);
            size++;
        }
    }

    public void deleteFromIndex(int index){
        int ctr=0;
        CellNode temp = head;
        if (index > this.size-1 || index <0)
            throw new NoSuchElementException();
        while (ctr+1!=index){
            temp = temp.next;
            ctr++;
        }
        temp.next = temp.next.next;
        size--;
    }

    public void deleteFromStart(){
        if (head != null) {
            head = head.next;
            size--;
        }
    }

    public void replaceAtIndex(CellPhone cp, int index){
        if (index > this.size-1 || index < 0)
            return;
        CellNode temp = head;
        int ctr = 0;
        while (ctr+1!=index){
            temp = temp.next;
            ctr++;
        }
        temp.next = new CellNode((CellPhone) cp.clone(),temp.next.next);
    }

    public CellNode find(long sn){
        int ctr = 0;
        CellNode temp = head;
        while (temp!=null && temp.cp.getSerialNum()!=sn){
            temp = temp.next;
        }
        return temp;
    }

    public boolean contains(long sn){
        CellNode temp = head;
        while (temp!=null && temp.cp.getSerialNum()!=sn){
            temp = temp.next;
        }
        if (temp == null)
            return false;
        return true;
    }

    public void showContents(){
        CellNode temp = head;
        int ctr = 1;
        System.out.println();
        String s = "The current size of the list is "+this.size+". Here are the contents of the list\n" +
                "=====================================================================\n";
        while (temp!=null){
            s += temp.cp.toString()+" ---> ";
            temp = temp.next;
            if (ctr%3==0)
                s+="\n";
            ctr++;

        }
        s +="X";
        System.out.println(s);
        System.out.println();
    }

    public boolean equals(CellList o){
        if (o.size==this.size){
            CellNode temp = head;
            while (temp !=null){
                if (!this.equals(o))
                    return false;
                temp = temp.next;
            }
            return true;
        }else
            return false;
    }


}
