import java.util.ArrayList;

public class Mobile {
    private String myNum;
    private ArrayList<Contact> myCont = new ArrayList<Contact>();

    public Mobile(String myNum) {
        this.myNum = myNum;
    }
    public boolean addCont(Contact contact)
    {
        if(findCont(contact.getName())>=0)
        {
            System.out.println("Contact already found");
            return false;
        }
        myCont.add(contact);
        return true;
    }
    private int findCont(Contact contact)
    {
        return  myCont.indexOf(contact);
    }
    private int findCont(String contname)
    {
        for(int i=0;i<myCont.size();i++)
        {
            Contact contact = myCont.get(i);
            if(contact.getName().equals(contname))
            {
                return i;
            }
        }
        return -1;
    }
    public boolean update(Contact oldcont, Contact newcont)
    {
        int ind = findCont(oldcont);
        if(ind<0)
        {
            System.out.println("Given old contact no found");
            return false;
        }
        myCont.set(ind,newcont);
        return true;
    }
    public boolean remove(Contact contact)
    {
        int ind = findCont(contact);
        if(ind<0)
        {
            System.out.println("Given  contact not found");
            return false;
        }
        myCont.remove(ind);
        return true;
    }
    public Contact query(String  name)
    {
        int ind = findCont(name);
        if(ind>=0)
            return myCont.get(ind);
        else
            return null;
    }
    public void  printCon()
    {
        System.out.println("Contact list:");
        for(int i=0;i<myCont.size();i++)
        {
            System.out.println("Contact name is "+ myCont.get(i).getName()+" with a contact number "+myCont.get(i).getNum());
        }
    }





}
