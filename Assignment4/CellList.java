/*
 * Nigel Yong Sao Young, 40089856
 * COMP249
 * Assignment 4
 * Due 21/03/19
 */

import java.util.NoSuchElementException;

public class CellList {
    private CellNode head;
    private int size;
    private int ctr=0;

    public int getSize() {
        return size;
    }

    public int getCtr() {
        return ctr;
    }

    public CellList() {
        this.head = null;
        this.size = 0;
    }

    public CellList(CellList cellList){
        this.head = null;
        this.size = cellList.size;

        CellNode othertemp = cellList.head;
        head = new CellNode(othertemp.getCp(),head);
        CellNode temp = head;

        othertemp = othertemp.next;
        while(othertemp!= null){
            temp.next = new CellNode(new CellPhone(othertemp.getCp(), othertemp.getCp().getSerialNum()),null);
            temp = temp.next;
            othertemp = othertemp.next;
        }
        temp = othertemp = null;
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
        protected Object clone() {
            return new CellNode((CellPhone)cp.clone(), this.next);
        }
    }

    public void addToStart(CellPhone cp){
        if (find(cp.getSerialNum())==null) {
            head = new CellNode(new CellPhone(cp,cp.getSerialNum()), head);
            size++;
        }
    }

    public void insertAtIndex(CellPhone cp, int index){
        int ctr=0;
        CellNode temp = head;
        if (find(cp.getSerialNum())==null) {
            if (index > this.size - 1 || index <0)
                throw new NoSuchElementException();
            if (index == 0) {
                this.addToStart(new CellPhone(cp,cp.getSerialNum()));
                return;
            }
            while (temp.next != null && ctr + 1 != index) {
                temp = temp.next;
                ctr++;
            }
            temp.next = new CellNode(new CellPhone(cp,cp.getSerialNum()), temp.next);
            size++;
        }
    }

    public void deleteFromIndex(int index){
        int ctr=0;
        CellNode temp = head;
        if (index > this.size-1 || index <0)
            throw new NoSuchElementException();
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }
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

    public void replaceAtIndex(CellPhone cp, int index) {
        if (index > this.size - 1 || index < 0)
            return;
        if (index == 0){
            head = new CellNode(new CellPhone(cp,cp.getSerialNum()), head.next);
            return;
        }
        CellNode temp = head;
        int ctr = 0;
        while (ctr+1!=index){
            temp = temp.next;
            ctr++;
        }
        temp.next = new CellNode(new CellPhone(cp,cp.getSerialNum()),temp.next.next);
    }

    // This method may result in a privacy leak as it returns a pointer to a specific location in the linked list
    // To avoid privacy leak, make the node class a private inner class in the linked list class
    public CellNode find(long sn){
        CellNode temp = head;
        ctr = 0;
        while (temp!=null && temp.cp.getSerialNum()!=sn){
            temp = temp.next;
            ctr++;
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
        String s = "The current size of the list is "+this.size+". Here are the contents of the list.\n" +
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

    public boolean equals(CellList o) {
        if (o.size == this.size) {
            CellNode temp = head;
            CellNode temp2 = o.head;
            while (temp != null) {
                if (!temp.cp.equals(temp2.cp))
                    return false;
                temp = temp.next;
                temp2 = temp2.next;
            }
            return true;
        } else
            return false;
    }
}
