
public class FamilyTree {

    public class ChildNameNotUniqueException extends Exception {
    };

    private class FamilyTreeNode {

        private String name;
        private Integer identifier;
        private FamilyTreeNode partner;
        private FamilyTreeNode sibling;
        private FamilyTreeNode child;
        
    }

    private FamilyTreeNode Ancestor;
 
    public FamilyTree(String AncestorName) {
        this.Ancestor = new FamilyTreeNode();
         this.Ancestor.name = AncestorName;
        
    }

    public String toString() {
        String AncestorDetails = new String();
        AncestorDetails += this.Ancestor.name + Ancestor.identifier + "\n";
         if (Ancestor.partner != null){
            AncestorDetails += "  partner " + this.Ancestor.partner.name + " " + this.Ancestor.partner.identifier + "\n";
        } else {
            AncestorDetails += "\n";
        }
         
         FamilyTreeNode FamilyMember = this.Ancestor.child;
         
        if (FamilyMember == null) {
            AncestorDetails += "  has no children\n";
        } else {
            while (FamilyMember != null) {
                AncestorDetails += "  " + FamilyMember.name + "\n";
                if (FamilyMember.partner != null){
                 AncestorDetails += "  partner " + FamilyMember.name + " " + FamilyMember.identifier + "\n";
                }
                  FamilyMember = FamilyMember.sibling;
            }

        }
    
       return AncestorDetails; 
    }
 


    
    public void addChild(String name) throws ChildNameNotUniqueException {
        
            FamilyTreeNode FamilyMember = this.Ancestor.child;
            while (FamilyMember != null) {

                if (FamilyMember.name.equalsIgnoreCase(name)) 
                {
                    throw new ChildNameNotUniqueException();
                }
                FamilyMember = FamilyMember.sibling;
            }
            if (Ancestor.child == null) {
                FamilyTreeNode Member = new FamilyTreeNode();
                Member.name = name;
                this.Ancestor.child = Member;
            } else if (this.Ancestor.child != null) {

                FamilyTreeNode member = new FamilyTreeNode();
                FamilyTreeNode next = this.Ancestor.child;
                member.name = name;
                 if (this.Ancestor.child == null) {
                    this.Ancestor.child = member;
                } else {
                    while (next.sibling != null) {
                        next = next.sibling;
                    }
                    next.sibling = member;

                }
            }

    }

    
 public void addPartner(Integer identifier) {
        
        Boolean memberFound = false;
        
        if (identifier.equals(this.Ancestor.identifier)) {
            memberFound = true;
        } else {
            this.Ancestor = this.Ancestor.child;                                                   

            Boolean endSearch = false;

            do {                                                                               
                if (identifier.equals(this.Ancestor.identifier)) {                                   
                    memberFound = true;                                                                
                    endSearch = true;                                                                  
                } else if (this.Ancestor.sibling == null) {                                         
                    endSearch = true;                                                                   
                } else {                                                                            
                    this.Ancestor = this.Ancestor.sibling;                                               
                }
            } while (endSearch == false);                                                           
        }
        
        if (memberFound == true) {                                                            
            if (this.Ancestor.partner == null) {                                                     
                FamilyTree.FamilyTreeNode newNode = new FamilyTree.FamilyTreeNode();                                          
                newNode.name = Input.getString("Please Input The Partner's Name: ");                  
                this.Ancestor.identifier++;                                                                        
                newNode.partner = this.Ancestor;                                                         
                this.Ancestor.partner = newNode;                                                         
            } else {                                                                               
                System.out.println("Already Has A Partner.");                                        
            }
        } else {                                                                                
            System.out.println("Member Not Found In Tree.");                                            
        }
    }
}
