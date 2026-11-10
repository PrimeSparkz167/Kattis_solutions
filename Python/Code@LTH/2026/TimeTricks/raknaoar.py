import heapq
def main():
    n,q = map(int,input().split())
    isl=[]#(size,countryIndx)
    c2=[0 for _ in range(n)]#(numIsl)
    heap2=[(0,-(n-1))]#(numIslands,countryIndx)
    ans=[]
    for i in range(n):
        l=list(map(int,input().split()))
        #heap2.append((0,i)
        for s in l[1:]:
            isl.append((s,i))
    for i in range(q):
        ans.append((int(input()),i,0)) #(A,Q index,answer)
    ans.sort(key=lambda x:-x[0]) 
    isl.sort(key=lambda x:-x[0])
    heapq.heapify(heap2)
    count=0
    for i,t in enumerate(ans):
        while(count<len(isl)) and (isl[count][0]>=t[0]):
            c2[isl[count][1]]+=1
            heapq.heappush(heap2,(-c2[isl[count][1]],-isl[count][1]))
            count+=1
        ans[i]=(t[0],t[1],-heap2[0][1])
    ans.sort(key=lambda x:x[1])
    for t in ans:
        print(t[2]+1)
    #print(ans)
if __name__=="__main__":
    main()
