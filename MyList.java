public class MyList <T>
{
    private T [] array;
    private int capacity;
    private int size = 0;

    public MyList()
    {
        this.capacity = 10;
        this.array = (T[]) new Object [capacity];
    }

    public MyList(int capacity)
    {
        this.capacity = capacity;
        this.array = (T[]) new Object [capacity];
    }

    public int size()
    {
        return this.size;
    }

    public int getCapacity()
    {
        return this.capacity;
    }

    public void add(T data)
    {
        if(size == capacity)
        {
            T [] tempArray = (T[]) new Object [capacity*2];
            System.arraycopy(this.array, 0, tempArray, 0, this.capacity);
            this.array = tempArray;
            this.capacity = this.capacity*2;
        }
        else
        {
            this.array[size++] = data;
        }
        
    }

    public T get(int index)
    {
        try
        {
            return this.array[index];
        } 
        catch (Exception e)
        {
            return null;
        }
    }

    public void remove(int index)
    {
        try
        {
            this.array[index] = null;
            for (int i = index; i < size - 1; i++)
            {
            this.array[index] = this.array[index + 1];
            }
            this.size--;
        } 
        catch (Exception e)
        {}
    }

    public void set(int index, T data)
    {
        try
        {
            this.array[index] = data;
        } 
        catch (Exception e)
        {}
    }

    public String toString()
    {
        String sysout = "["; 
        for (T t : array)
        {
            try
            {
                if(t.equals(null))
                {}
                else
                {
                    sysout = sysout + t + ",";
                }
            }catch (Exception e){}
        }
        sysout = sysout + "]";
        return sysout;
    }

    public int indexOf(T data)
    {
        for(int i = 0; i <= size; i++)
        {
            if(data.equals(this.array[i]))
            {
                return i;
            }
        }
        return (-1);
    }

    public int lastIndexOf(T data)
    {
        for(int i = size; i >= 0 ; i--)
        {
            if(data.equals(this.array[i]))
            {
                return i;
            }
        }
        return (-1);
    }

    public boolean isEmpty()
    {
        return size == 0 ? true : false;
    }

    public T [] toArray()
    {
        return this.array;
    } 

    public void clear()
    {
        this.array = (T[]) new Object[getCapacity()];
    }

    public MyList <T> subList(int start, int finish)
    {
        if(start > finish)
        {
            int temp = finish;
            finish = start;
            start = temp;
        }

        MyList <T> list = new MyList <> (finish - start + 1);

        for(int i = start; i <= finish; i++)
        {
            list.add(this.array[i]);
        }

        return list;
    }

    public boolean contains(T object)
    {
        try
        {
            for(T t : this.array)
            {
                if(t.equals(object))
                {
                    return true;
                }
            }
        } 
        catch (Exception e)
        {
            return false;
        }
        return false;
    }
}