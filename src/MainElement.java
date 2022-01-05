public class MainElement {
    public static void main(String[] args) {
        act();
    }
    public static void act (){
        char [] chars1 = {'a','a','b','c','d','e','e','f','g','g','g'};
        char [] chars2 = {'a','a','b','b','c','d','d','e','f','f'};
        Element [] elements= elementsArrangedArrangement(chars1);
        Element [] elements2= elementsArrangedArrangement(chars2);
        Element[] elementsFullArr= connecting2Arrays(elements,elements2);
        Element [] arrAfterActions=finalElement(elementsFullArr);
        for (int i=0; i<arrAfterActions.length; i++){
            System.out.println(arrAfterActions[i]);
        }

    }
    public static Element [] elementsArrangedArrangement(char [] chars){
        Element [] arr= new Element[0];
        for (int i=0; i< chars.length; i++){
            int count= rehearsalsOfChar(chars,chars[i]);
            arr=addElement(arr,element(chars[i],count));
            chars=charsWithoutChar(chars[i],count,chars);
            i=-1;
        }
        return arr;
    }
    public static Element element(char later, int count){
    Element element=new Element(later,count);
    return element;
    }
    public static int rehearsalsOfChar(char [] chars, char ch){
        int rehearsalsOfChar=0;
        for (int i=0; i< chars.length;i++){
            if (chars[i]==ch){
                rehearsalsOfChar++;
            }
        }
        return rehearsalsOfChar;
    }
    public static char [] charsWithoutChar(char toRemove, int count, char [] chars){
        char [] newChar= new char[chars.length-count];
        for (int i=0,k=0; i< chars.length; i++){
            if (chars[i]!=toRemove){
                newChar[k]=chars[i];
                k++;
            }
        }
        return newChar;
    }
    public static Element [] addElement (Element [] elements, Element element){
        Element [] newElement=new Element[elements.length+1];
        for (int i=0; i<elements.length;i++){
            newElement[i]=elements[i];
        }
        newElement[elements.length]=element;
        return newElement;
    }
    public static Element [] connecting2Arrays(Element [] arr, Element [] arr2){
        Element [] elements= new Element[arr.length+arr2.length];
        int index=0;
        copyArrayׂ(elements, arr, 0);
        copyArrayׂ(elements, arr2, arr.length);
        return elements;
    }
    public static void copyArrayׂ(Element [] elements, Element [] copy, int index){
        for (int i=0; i< copy.length; i++){
            elements[index]=copy[i];
            index++;
        }
    }
    public static Element [] removeElement(Element element, Element []arr){
        Element [] elementsAfterRemove=new Element[arr.length-1];
        for (int i=0,k=0; i< arr.length ; i++){
            if (!arr[i].equals(element)){
                elementsAfterRemove[k]=arr[i];
                k++;
            }
        }
        return elementsAfterRemove;
    }
    public static Element [] finalElement(Element [] fullArr){
        for (int i=0; i< fullArr.length; i++){
            int count=0;
            for (int j=i+1; j<fullArr.length; j++){
                if (fullArr[i].getLetter()==fullArr[j].getLetter()){
                    count=fullArr[i].getAmount()+fullArr[j].getAmount();
                    fullArr[i]=element(fullArr[i].getLetter(),count);
                    fullArr=removeElement(fullArr[j],fullArr);
                    i=-1;
                    break;
                }
            }
        }
        return fullArr;
    }

}
