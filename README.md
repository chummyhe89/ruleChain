# ruleChain document

## How to use

```java
RuleChain chain = new RuleChain();
RuleContext context = new RuleContext();
CompareRuleNode payRule = CompareRuleNode.CompareRuleNodeBuilder.create().name("pay two much test")
            .rhsValue(2).negativeBreak(true).lhsKey("pay_amount")
            .operator(EQ.INSTANCE).priority(5).build();
context.put("pay_amount",10000.0);
chain.addRule(payRule);
chain.applyRule(context);

```