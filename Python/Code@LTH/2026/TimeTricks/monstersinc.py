def main():
    n = int(input())
    ms=[(tuple(map(int,input().split()))) for _ in range(n)]
    q=int(input())
    xs=[int(input()) for _ in range(q)]
    #dx=[xs[i+1]-xs[i] for i in range(q-1)]
    #x=xs[0]
    ans=[]
    #c=0
    b=0
    mk=0
    for x in xs:
        while mk<n:
            if x+b>=ms[mk][0]:
                b+=ms[mk][1]
                mk+=1
            else:
                break
        print(mk)
    #ans=ans+[n for _ in range(q-len(ans))]
    #print("\n".join([str(y)for y in ans]))
    
if __name__  =="__main__":
    main()