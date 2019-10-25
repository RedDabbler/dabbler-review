package com.redDabbler.review.pattern.chainOfResponsibility;

import com.google.common.collect.Lists;

import java.util.List;

public class FilterChain implements IFilter{
    private List<IFilter> filterList = Lists.newArrayList();
    int index ;


    // 链式编程 技巧
    public FilterChain addFilter(IFilter filter){
        filterList.add(filter);
        return this;
    }

    public void removeFilter(IFilter filter){
        filterList.remove(filter);
    }

    public List<IFilter> getFilterList() {
        return filterList;
    }

    public void setFilterList(List<IFilter> filterList) {
        this.filterList = filterList;
    }

    @Override
    public void process(Request request, Response response, FilterChain filterChain) {
        if(index == filterList.size()) return ;
        IFilter filter = getFilterList().get(index);
        index++;
        // 调用下一个Filter
        filter.process(request,response,filterChain);
    }
}
