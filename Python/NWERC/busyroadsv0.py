from heapq import heappop, heappush
def main():
    n,m,C =map(int,input().split())
    adj=[[] for _ in range(n)]
    for _ in range(m):
        a,b,c,l,r=map(int,input().split())
        adj[a-1].append((b-1,a-1,c,l,r))
        adj[b-1].append((a-1,b-1,c,l,r))
    dist=dijkstra(n,C,adj,0)
    print(dist[-1])
def dijkstra(n,c,graph, start):
    dist = [float("inf")] * n
    dist[start] = 0
    queue = [(0, start)]
    while queue:
        path_len, v = heappop(queue)
        if path_len == dist[v]:
            for w,_, edge_len,l,r in graph[v]:
                t=path_len
                if(t%c<l):
                    t+=(l-t%c)
                elif(t%c>r):
                    t+=(l+c-t%c)
                if edge_len + t <= dist[w]:
                    dist[w]= edge_len + t
                    heappush(queue, (edge_len + t, w))
    return dist
if __name__=="__main__":
    main()