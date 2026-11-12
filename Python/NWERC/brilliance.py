def main():
    n:int=int(input())
    ans:int=0
    d:dict[tuple[int,int],bool]={}
    for _ in range(n-1):
        u,v=map(int,input().split())
        d[(u,v)]=True
        d[(v,u)]=True
    for _ in range(n-1):
        ans+= 1 if(tuple(map(int,input().split())) not in d) else 0
    print(ans)
if __name__=="__main__":
    main()