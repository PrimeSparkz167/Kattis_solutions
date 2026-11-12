import sys
from heapq import heappop, heappush
input = lambda:sys.stdin.readline().rstrip()
def main():
    def dijkstra(graph):
        dist = [2<<50] * n
        dist[0] = 0
        queue = [(0, 0)]
        while queue:
            path_len, v = heappop(queue)
            if(v==n-1):
                return dist
            if path_len == dist[v]:
                for w, m in graph[v]:
                    t=path_len
                    edge_len=times[m]
                    if edge_len+t<dist[w]:
                        phase=t%c
                        l=opens[m]
                        r=closes[m]
                        if(phase<l):
                            t+=(l-phase)
                        elif(phase>r):
                            t+=(l+c-phase)
                        if edge_len + t < dist[w]:
                            dist[w]= edge_len + t
                            heappush(queue, (edge_len + t, w))
        return dist
    n,m,c =map(int,input().split())
    adj=[[] for _ in range(n)]
    times=[]
    opens=[]
    closes=[]
    for i in range(m):
        a,b,time,op,clos=map(int,input().split())
        adj[a-1].append((b-1,i))
        adj[b-1].append((a-1,i))
        times.append(time)
        opens.append(op)
        closes.append(clos)
    dists=dijkstra(adj)
    print(dists[-1])

if __name__=="__main__":
    main()